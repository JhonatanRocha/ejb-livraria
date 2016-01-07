package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.interceptor.InterceptorLogger;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
//@Interceptors({InterceptorLogger.class})
public class AutorDao {

	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	public void aposCriacao(){
		System.out.println("AutorDao foi criado");
	}
	
	//Inserir Autor no Banco
	public void salva(Autor autor) {
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("Salvando autor " + autor.getNome());

		this.entityManager.persist(autor);
		
		System.out.println("Salvou Autor " + autor.getNome());
	
		System.out.println("AutorDAO: Tempo gasto " + (System.currentTimeMillis() - currentTimeMillis));
		//Simulando um Webservice externo que gerou um erro:
		//throw new RuntimeException("Serviço externo deu erro!");
	}
	
	//Listagem dos Autores
	public List<Autor> todosAutores() {
		return this.entityManager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	//Busca de Autor Por ID
	public Autor buscaPelaId(Integer autorId) {
		return this.entityManager.find(Autor.class, autorId);
	}
}
