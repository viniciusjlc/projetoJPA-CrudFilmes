package br.edu.cesmac.si.noticia.repository;

import br.edu.cesmac.si.noticia.JPA.JpaUtil;
import br.edu.cesmac.si.noticia.domain.Usuario;
import br.edu.cesmac.si.noticia.shared.DTOs.ParametrosLoginDTO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import static br.edu.cesmac.si.noticia.shared.Queries.sessao.*;

public class SessaoJPA {
    public Usuario verificarUsuario (ParametrosLoginDTO parametrosLoginDTO) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(QUERY_VERIFICAR_USUARIO, Usuario.class)
                .setParameter("email", parametrosLoginDTO.getEmail())
                .setParameter("senha", parametrosLoginDTO.getSenha());
        Usuario usuarioLocal;
        try{
            usuarioLocal = (Usuario) query.getSingleResult();
        }catch (NoResultException e){
            usuarioLocal = null;
        }
        em.close();
        return usuarioLocal;
    }
}
