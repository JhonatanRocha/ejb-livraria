package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;

	//Busca pelo de Usuario pelo Login 
	public Usuario buscaPeloLogin(String login) {
        return (Usuario) this.entityManager.createQuery("select u from Usuario u where u.login=:pLogin").setParameter("pLogin", login).getSingleResult();
	}
}
