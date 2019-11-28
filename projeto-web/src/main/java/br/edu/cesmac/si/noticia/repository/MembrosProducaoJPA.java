package br.edu.cesmac.si.noticia.repository;

import br.edu.cesmac.si.noticia.JPA.JpaUtil;
import br.edu.cesmac.si.noticia.domain.MembroProducao;

import javax.persistence.EntityManager;
import java.util.List;

public class MembrosProducaoJPA {
    public void cadastrar(MembroProducao membroProducao) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(membroProducao);
        em.getTransaction().commit();
        em.close();
    }

    public void alterar(MembroProducao membroProducao) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(membroProducao);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(MembroProducao membroProducao) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(membroProducao));
        em.getTransaction().commit();
        em.close();
    }

    public List<MembroProducao> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<MembroProducao> membrosProducao = em.createQuery("select mp from membros_producao mp").getResultList();
        em.close();
        return membrosProducao;
    }

}
