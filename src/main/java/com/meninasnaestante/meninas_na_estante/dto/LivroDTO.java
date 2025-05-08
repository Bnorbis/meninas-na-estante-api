package com.meninasnaestante.meninas_na_estante.dto;

import com.meninasnaestante.meninas_na_estante.entity.Livro;

import jakarta.persistence.Column;


public class LivroDTO {

	Long id;
    String titulo;
    String autora;
    String genero;
    String descricao;
    String biografiaAutora;
    Integer anoPublicacao;
    String editora;
    
    @Column(name = "imagem_url")
    String imagemUrl;
    
    
    
    
	public LivroDTO() {}


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

	public Integer getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Integer anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}


	public LivroDTO(Livro livro) {
	    this.id = livro.getId();
	    this.titulo = livro.getTitulo();
	    this.autora = livro.getAutora();
	    this.genero = livro.getGenero();
	    this.descricao = livro.getDescricao();
	    this.biografiaAutora = livro.getBiografiaAutora();
	    this.anoPublicacao = livro.getAnoPublicacao();
	    this.editora = livro.getEditora();
	    this.imagemUrl = livro.getImagemUrl();

	}



}
