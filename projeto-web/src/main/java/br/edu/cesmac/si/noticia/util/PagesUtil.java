package br.edu.cesmac.si.noticia.util;

import org.primefaces.context.RequestContext;

import javax.faces.context.FacesContext;
import java.io.IOException;

import static br.edu.cesmac.si.noticia.shared.Constantes.Constantes.outros.*;

public class PagesUtil {
    public static void redirectPage(String pagina){
        try{
            FacesContext context  = FacesContext.getCurrentInstance();
            String url = context.getExternalContext().getRequestContextPath();
            context.getExternalContext().redirect(url+"/pages/"+pagina+".faces");
        }catch (IOException e){
            MensagemUtil.erro("Erro ao acessar a pagina: "+pagina, e.getMessage());
        }
    }

    public static void fecharDialog(String dialog) {
        getRequestContext().execute("PF('" + dialog + "').hide();");
    }

    public static void atualizarComponente(String componente){
        getRequestContext().update(componente);
    }

    public static void abrirDialogAtualizado(String nomeDialog){
        atualizarComponente(FORM+nomeDialog);
        abirDialog(DLG+nomeDialog);
    }

    public static void abirDialog(String dialog) {
        getRequestContext().execute("PF('" + dialog + "').show();");
    }

    private static RequestContext getRequestContext() {
        return RequestContext.getCurrentInstance();
    }
}
