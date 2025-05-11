package com.meninasnaestante.meninas_na_estante.controller;

import com.meninasnaestante.meninas_na_estante.dto.LoginRecordDTO;
import com.meninasnaestante.meninas_na_estante.dto.RegistroRecordDTO;
import com.meninasnaestante.meninas_na_estante.dto.ResponseRecordDTO;
import com.meninasnaestante.meninas_na_estante.entity.Usuario;
import com.meninasnaestante.meninas_na_estante.repository.UsuarioRepository;
import com.meninasnaestante.meninas_na_estante.security.TokenService;
import com.meninasnaestante.meninas_na_estante.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository repository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioService usuarioService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRecordDTO body){
        Usuario usuario = this.repository.findByEmail(body.email())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não encontrado."));
        if(passwordEncoder.matches(body.password(), usuario.getPassword())){
            String token = this.tokenService.generateToken(usuario);
            return ResponseEntity.ok(new ResponseRecordDTO(usuario.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/registrar")
    public ResponseEntity registrar(@RequestBody RegistroRecordDTO body){
        Optional<Usuario> usuario = this.repository.findByEmail(body.email());
        if(usuario.isEmpty()){
            Usuario novoUsuario = new Usuario();
            novoUsuario.setPassword(passwordEncoder.encode(body.password()));
            novoUsuario.setEmail(body.email());
            novoUsuario.setNome(body.nome());
            this.repository.save(novoUsuario);
            String token = this.tokenService.generateToken(novoUsuario);
            return ResponseEntity.ok(new ResponseRecordDTO(novoUsuario.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
