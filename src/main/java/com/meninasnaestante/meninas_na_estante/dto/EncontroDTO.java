package com.meninasnaestante.meninas_na_estante.dto;

import java.time.LocalDateTime;

import com.meninasnaestante.meninas_na_estante.entity.Encontro;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EncontroDTO {
    Long id;
    String nomeProponente;
    String livroSugerido;
    String dataHora;
    String descricao;
    String data;

    public Encontro toEntity() {
        Encontro encontro = new Encontro();
        encontro.setId(id);
        encontro.setNomeProponente(nomeProponente);
        encontro.setDescricao(descricao);
        encontro.setDataHora(LocalDateTime.parse(dataHora));
        encontro.setLivroSugerido(livroSugerido);
        return encontro;
    }
    
    
    public static EncontroDTO fromEntity(Encontro encontro) {
        EncontroDTO dto = new EncontroDTO();
        dto.setId(encontro.getId());
        dto.setNomeProponente(encontro.getNomeProponente());
        dto.setLivroSugerido(encontro.getLivroSugerido());
        dto.setDataHora(encontro.getDataHora().toString());
        dto.setDescricao(encontro.getDescricao());
        return dto;
    }


}
