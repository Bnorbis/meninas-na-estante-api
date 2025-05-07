package com.meninasnaestante.meninas_na_estante.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String autora;
	private String genero;
	private String descricao;
	private String biografiaAutora;
	private String editora;
	private Integer anoPublicacao;
	private String imagemUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutora() {
		return autora;
	}

	public void setAutora(String autora) {
		this.autora = autora;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getBiografiaAutora() {
		return biografiaAutora;
	}

	public void setBiografiaAutora(String biografiaAutora) {
		this.biografiaAutora = biografiaAutora;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Integer getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Integer anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	public Livro(Long id, String titulo, String autora, String genero, String descricao, String biografiaAutora,
			String editora, Integer anoPublicacao, String imagemUrl) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autora = autora;
		this.genero = genero;
		this.descricao = descricao;
		this.biografiaAutora = biografiaAutora;
		this.editora = editora;
		this.anoPublicacao = anoPublicacao;
		this.imagemUrl = imagemUrl;
	}

	public Livro() {
	}

}
