package br.edu.cesmac.si.noticia.repository;

import br.edu.cesmac.si.noticia.JPA.JpaUtil;
import br.edu.cesmac.si.noticia.domain.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

import static br.edu.cesmac.si.noticia.shared.Queries.usuario.QUERY_VERIFICAR_EMAIL_NAO_UTILIZADO;

public class UsuarioJPA {

    public void cadastrar(Usuario usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public void alterar(Usuario usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Usuario usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(usuario));
        em.getTransaction().commit();
        em.close();
    }
    public List<Usuario> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Usuario> usuarios = em.createQuery("select u from usuarios u").getResultList();
        em.close();
        return usuarios;
    }

    public Boolean emailNaoUtilizado (String email) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(QUERY_VERIFICAR_EMAIL_NAO_UTILIZADO)
                .setParameter("email", email);
        boolean resultado = ((Long) query.getSingleResult()) == 0;
        em.close();
        return resultado;
    }
}
