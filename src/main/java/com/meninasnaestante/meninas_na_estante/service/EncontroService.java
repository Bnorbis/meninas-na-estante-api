package com.meninasnaestante.meninas_na_estante.service;

import com.meninasnaestante.meninas_na_estante.dto.EncontroDTO;
import com.meninasnaestante.meninas_na_estante.entity.Encontro;
import com.meninasnaestante.meninas_na_estante.repository.EncontroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EncontroService {

    private final EncontroRepository encontroRepository;

    public EncontroService(EncontroRepository encontroRepository) {
        this.encontroRepository = encontroRepository;
    }

    public List<EncontroDTO> listarEncontros(){
        return encontroRepository.findAll().stream().map(EncontroDTO::fromEntity).collect(Collectors.toList());
    }

    public EncontroDTO buscarEncontrosPorId(Long id){
        Encontro encontro = encontroRepository.findById(id).orElseThrow(() -> new RuntimeException("Encontro não encontrado"));
        return EncontroDTO.fromEntity(encontro);
    }

        public EncontroDTO criar(EncontroDTO dto){
        Encontro encontro = dto.toEntity();
        Encontro salvo = encontroRepository.save(encontro);
        return EncontroDTO.fromEntity(salvo);
    }

    public EncontroDTO atualizar(Long id, EncontroDTO dto) {
        Encontro encontro = encontroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Encontro não encontrado"));

        encontro.setNomeProponente(dto.getNomeProponente());
        encontro.setLivroSugerido(dto.getLivroSugerido());
        encontro.setDataHora(dto.getDataHora());
        encontro.setDescricao(dto.getDescricao());

        Encontro encontroAtualizado = encontroRepository.save(encontro);
        return EncontroDTO.fromEntity(encontroAtualizado);
    }

    public void deletar (Long id){
        if(!encontroRepository.existsById(id)){
            throw new RuntimeException("Encontro no encontrado");
        }
        encontroRepository.deleteById(id);
    }

}
