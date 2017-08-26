package br.com.restserver.model;

public class Filme {
	private Long id;
	private String titulo;
	private String genero;
	
	public Filme(Long id, String titulo, String genero) {
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
	}
	
	
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
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

}
