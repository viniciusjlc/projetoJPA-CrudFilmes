package br.edu.cesmac.si.noticia.repository;

import br.edu.cesmac.si.noticia.JPA.JpaUtil;
import br.edu.cesmac.si.noticia.domain.Filme;
import br.edu.cesmac.si.noticia.domain.NotaFilme;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
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

    public Double retornarNota(Integer idFilme, Integer idUsuario) {
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("SELECT nota AS nota FROM nota_filme WHERE id_filme = :id_filme AND id_usuario = :id_usuario", Double.class)
                .setParameter("id_filme", idFilme)
                .setParameter("id_usuario", idUsuario);
        Double resultadoLocal;
        try {
            resultadoLocal= (Double) query.getSingleResult();
        } catch (NoResultException e) {
            resultadoLocal = null;
        }
        em.close();
        return resultadoLocal;
    }

    public Double retornarNotaGeral(Integer idFilme) {
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("SELECT sum(nota)/count(*) AS nota FROM nota_filme WHERE id_filme = :id_filme", Double.class)
                .setParameter("id_filme", idFilme);
        Double resultadoLocal;
        try {
            resultadoLocal= (Double) query.getSingleResult();
        } catch (NoResultException e) {
            resultadoLocal = 0.0;
        }
        em.close();
        return resultadoLocal;
    }


    public void avaliarFilme(NotaFilme notaFilme) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(notaFilme);
        em.getTransaction().commit();
        em.close();
    }

}
