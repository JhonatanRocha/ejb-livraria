package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

@WebService
@Stateless
public class LivrariaService {

	@Inject
	LivroDao livroDao;
	
	@WebResult(name="autores")
	public List<Livro> getLivrosbyTitle(@WebParam(name="titulo")String titulo){
		
		System.out.println("LivrariaService: Procurando pelo titulo: " + titulo);
		
		return livroDao.getByTitle(titulo);
	}
}
