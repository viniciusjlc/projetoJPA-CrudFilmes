package br.edu.cesmac.si.noticia.repository;

import br.edu.cesmac.si.noticia.JPA.JpaUtil;
import br.edu.cesmac.si.noticia.domain.Filme;

import javax.persistence.EntityManager;
import java.util.List;

public class FilmeJPA {
    public void cadastrar(Filme filme) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(filme);
        em.getTransaction().commit();
        em.close();
    }

    public void alterar(Filme filme) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(filme);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Filme filme) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(filme));
        em.getTransaction().commit();
        em.close();
    }
    public List<Filme> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Filme> filmes = em.createQuery("select f from filmes f").getResultList();
        em.close();
        return filmes;
    }
}
