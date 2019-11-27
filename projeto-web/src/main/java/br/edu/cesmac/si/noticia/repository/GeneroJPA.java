package br.edu.cesmac.si.noticia.repository;

import br.edu.cesmac.si.noticia.JPA.JpaUtil;
import br.edu.cesmac.si.noticia.domain.Genero;

import javax.persistence.EntityManager;
import java.util.List;

public class GeneroJPA {
    public void cadastrar(Genero genero) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(genero);
        em.getTransaction().commit();
        em.close();
    }

    public void alterar(Genero genero) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(genero);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Genero genero) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(genero));
        em.getTransaction().commit();
        em.close();
    }
    public List<Genero> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Genero> generos = em.createQuery("select g from generos g").getResultList();
        em.close();
        return generos;
    }

}
