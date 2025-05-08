package com.meninasnaestante.meninas_na_estante.controller;

import com.meninasnaestante.meninas_na_estante.dto.EncontroDTO;
import com.meninasnaestante.meninas_na_estante.service.EncontroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/encontros")
public class EncontroController {

    private final EncontroService encontroService;

    public EncontroController(EncontroService encontroService) {
        this.encontroService = encontroService;
    }

    @GetMapping
    public List<EncontroDTO> listarTodos(){
        return encontroService.listarEncontros();
    }

    @GetMapping("/{id}")
    public EncontroDTO buscarPorId(@PathVariable Long id){
        return encontroService.buscarEncontrosPorId(id);
    }

    @PostMapping
    public EncontroDTO criar(@RequestBody EncontroDTO encontroDTO){
        return encontroService.criar(encontroDTO);
    }

    @PutMapping("/{id}")
    public EncontroDTO atualizar(@PathVariable Long id, @RequestBody EncontroDTO dto) {
        return encontroService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        encontroService.deletar(id);
    }

}
