package br.edu.cesmac.si.noticia.validators;

import br.edu.cesmac.si.noticia.controller.SessaoController;
import br.edu.cesmac.si.noticia.repository.UsuarioJPA;
import br.edu.cesmac.si.noticia.util.SessaoUtil;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static br.edu.cesmac.si.noticia.shared.Constantes.Constantes.mensagems.*;
import static br.edu.cesmac.si.noticia.util.VerificadorUtil.estaNuloOuVazio;

@FacesValidator ("EmailValidator")
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String email = (String) value;

        if (!estaNuloOuVazio(email)) {
            if (!isEmailValid(email)) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, MENSAGEM_EMAIL_INVALIDO_TITULO, MENSAGEM_EMAIL_INVALIDO_DETALHES));
            }else if(!emailNaoUtilizado(email) && !email.equals(SessaoUtil.retornarUsuarioDaSessao().getEmail())){
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, MENSAGEM_EMAIL_EM_USO_TITULO, MENSAGEM_EMAIL_EM_USO_DETALHES));
            }
        }
    }

    private static boolean isEmailValid(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

    private static boolean emailNaoUtilizado(String email){
        return new UsuarioJPA().emailNaoUtilizado(email);
    }

}