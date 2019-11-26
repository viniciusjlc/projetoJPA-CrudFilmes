package br.edu.cesmac.si.noticia.shared;

public interface Queries {
    interface sessao{
        String QUERY_VERIFICAR_USUARIO = "SELECT u FROM usuarios AS u WHERE u.email LIKE :email AND u.senha= :senha AND u.ativo is true";
    }

    interface usuario{
        String QUERY_VERIFICAR_EMAIL_NAO_UTILIZADO = "SELECT count(*) FROM usuarios AS u WHERE u.email LIKE :email";
    }

}
