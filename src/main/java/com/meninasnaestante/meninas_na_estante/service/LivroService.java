package com.meninasnaestante.meninas_na_estante.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.meninasnaestante.meninas_na_estante.dto.LivroDTO;

@Service
public class LivroService {

	private static final Logger logger = LoggerFactory.getLogger(LivroService.class);

	private final WebClient webClient;

	public LivroService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://localhost:9090/livros").build();
	}

	public List<LivroDTO> buscarLivrosporfiltro(String termo) {
		logger.info("Iniciando busca de livros para o termo: {}", termo);

		try {
			List<LivroDTO> livros = webClient.get()
					.uri(uriBuilder -> uriBuilder.path("/filtrar").queryParam("termo", termo).build()).retrieve()
					.onRawStatus(status -> status >= 400 && status < 500, response -> {
						logger.warn("Erro 4xx: Termo '{}' não encontrado.", termo);
						throw new RuntimeException("Erro na requisição: Verifique o termo de busca.");
					}).onRawStatus(status -> status >= 500, response -> {
						logger.error("Erro 5xx: Problema no servidor ao buscar termo '{}'.", termo);
						throw new RuntimeException("Erro interno no servidor.");
					}).bodyToMono(new ParameterizedTypeReference<List<LivroDTO>>() {
					}).block();

			logger.info("Livros retornados com sucesso: {}", livros);
			return livros;
		} catch (WebClientResponseException e) {
			logger.error("Erro no WebClient: Código HTTP {} - {}", e.getStatusCode(), e.getResponseBodyAsString());
			throw new RuntimeException("Erro na comunicação com o servidor.");
		} catch (Exception e) {
			logger.error("Erro inesperado: {}", e.getMessage());
			throw new RuntimeException("Erro inesperado.");
		}
	}
	
	public List<LivroDTO> getAllLivros() {
        try {
            logger.info("Buscando todos os livros...");

            List<LivroDTO> livros = webClient.get()
                .retrieve()
                .onRawStatus(status -> status >= 400 && status < 500, response -> {
                    logger.warn("Erro 4xx ao buscar livros.");
                    throw new RuntimeException("Erro na requisição: Verifique a API de livros.");
                })
                .onRawStatus(status -> status >= 500, response -> {
                    logger.error("Erro 5xx no servidor ao buscar livros.");
                    throw new RuntimeException("Erro interno no servidor.");
                })
                .bodyToMono(new ParameterizedTypeReference<List<LivroDTO>>() {})
                .block();

            logger.info("Livros retornados com sucesso: {}", livros);
            return livros;
        } catch (WebClientResponseException e) {
            logger.error("Erro no WebClient: Código HTTP {} - {}", e.getStatusCode(), e.getResponseBodyAsString());
            throw new RuntimeException("Erro na comunicação com o servidor.");
        } catch (Exception e) {
            logger.error("Erro inesperado: {}", e.getMessage());
            throw new RuntimeException("Erro inesperado.");
        }
    }

}