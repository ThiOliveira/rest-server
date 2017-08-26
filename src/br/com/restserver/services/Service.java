package br.com.restserver.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import br.com.restserver.dao.CinemaDao;
import br.com.restserver.model.Filme;


@Path("/filmes")
public class Service {
	
	@POST	
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/cadastrar")
	public String cadastrar(String filme){
		Gson gson = new Gson();
		Filme filmeJson = gson.fromJson(filme, Filme.class);
		CinemaDao.getInstance().cadastrar(filmeJson);
		return "Inserido";
	}
	
	@GET
	@Produces("application/json")
	@Path("/listar")
	public String listar() {
		return CinemaDao.getInstance().listar();
		
	}
	
	@DELETE
	@Produces("application/json")
	@Path("/excluir/{codigo}")	
	public String excluir(@PathParam("codigo") String codigo){
		CinemaDao.getInstance().excluir(Long.valueOf(codigo));
		return "Excluído";
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/editar")
	public String editar(String filme) {
		Gson gson = new Gson();
		Filme filmeJson = gson.fromJson(filme, Filme.class);
		CinemaDao.getInstance().editar(filmeJson);
		return "Editado";
	}

}
