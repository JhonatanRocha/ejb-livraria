package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	//Inserir Livro no Banco
	public void salva(Livro livro) {
		this.entityManager.persist(livro);
	}
	
	//Listar todos os livros do Banco
	public List<Livro> todosLivros() {
		return this.entityManager.createQuery("select a from Livro a", Livro.class).getResultList();
	}

	public List<Livro> getByTitle(String titulo) {
		
		TypedQuery<Livro> livrosPeloTitulo = this.entityManager.createQuery("select l from Livro l where l.titulo like :pTitulo", Livro.class);
		livrosPeloTitulo.setParameter("pTitulo", "%" + titulo + "%");
		return livrosPeloTitulo.getResultList();
	}
}
