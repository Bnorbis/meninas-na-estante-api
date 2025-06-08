package com.meninasnaestante.meninas_na_estante.dto;

import com.meninasnaestante.meninas_na_estante.entity.Encontro;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class EncontroDTO {
    Long id;
    String nomeProponente;
    String livroSugerido;
    LocalDateTime dataHora;
    String descricao;

    public Encontro toEntity() {
        Encontro encontro = new Encontro();
        encontro.setId(id);
        encontro.setNomeProponente(nomeProponente);
        encontro.setDescricao(descricao);
        encontro.setDataHora(dataHora);
        encontro.setLivroSugerido(livroSugerido);
        return encontro;
    }

    public static EncontroDTO fromEntity(Encontro encontro) {
        EncontroDTO dto = new EncontroDTO();
        dto.setId(encontro.getId());
        dto.setNomeProponente(encontro.getNomeProponente());
        dto.setLivroSugerido(encontro.getLivroSugerido());
        dto.setDataHora(encontro.getDataHora());
        dto.setDescricao(encontro.getDescricao());
        return dto;
    }


}
