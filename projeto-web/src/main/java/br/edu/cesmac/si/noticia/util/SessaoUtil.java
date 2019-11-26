package br.edu.cesmac.si.noticia.util;

import br.edu.cesmac.si.noticia.domain.Usuario;

import javax.faces.context.FacesContext;
import java.util.Map;

import static br.edu.cesmac.si.noticia.shared.Constantes.Constantes.outros.*;

public class SessaoUtil {
    public static void colocarVariavelNaSessao(String nomeValor, Object valor){
        getSessionMap().put(nomeValor, valor);
    }

    public static void excluirVariavelDaSessao(String nomeValor){
        getSessionMap().remove(nomeValor);
    }

    public static Object retornarVariavelDaSessao(String nomeValor){
        return getSessionMap().get(nomeValor);
    }

    private static Map<String, Object> getSessionMap() {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    }

    public static Usuario retornarUsuarioDaSessao(){
        return (Usuario) getSessionMap().get(USUARIO_DA_SESSAO);
    }
}
