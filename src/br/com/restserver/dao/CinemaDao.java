package br.com.restserver.dao;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.com.restserver.model.Filme;

public class CinemaDao {
	List<Filme> filmes = new ArrayList<>();
	Filme filme;
	private static CinemaDao instance;
	

	public static CinemaDao getInstance() {
        if (instance == null)
            instance = new CinemaDao();
        return instance;
    }
	
	public String listar() {
		new ArrayList<>();
		
		filmes.add(new Filme(1L, "Filme Teste", "Teste"));
		Gson gson = new Gson();
		return gson.toJson(filmes);
	}
	
	public void cadastrar(Filme filme) {
		filmes.add(filme);
	}
	
	public String excluir(Long codigo) {
		for (Filme filme : filmes) {
			if (filme.getId().equals(Long.valueOf(codigo))) {
				filmes.remove(filme);
				return "Removido";
			}
		}
		return "Não encontrado";
	}
	
	public void editar(Filme filme) {
		for (Filme f : filmes) {
			if (f.getId().equals(filme.getId())) {
				f.setId(filme.getId());
				f.setTitulo(filme.getTitulo());
				f.setGenero(filme.getGenero());
			}
		}
	}
	
}
