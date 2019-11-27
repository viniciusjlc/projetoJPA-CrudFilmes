package br.edu.cesmac.si.noticia.shared.Constantes;

public interface Constantes {
    interface mensagems {
        String MENSAGEM_LOGIN_INVALIDO_TITULO = "Acesso Inválido.";
        String MENSAGEM_LOGIN_INVALIDO_DETALHES = "Email ou Senha Incorretos!";
        String MENSAGEM_EMAIL_INVALIDO_TITULO = "Email inválido!";
        String MENSAGEM_EMAIL_INVALIDO_DETALHES = "O email não está escrito corretamente.";
        String MENSAGEM_EMAIL_EM_USO_TITULO = "Email em uso!";
        String MENSAGEM_EMAIL_EM_USO_DETALHES = "Uma conta já foi criada usando esse email.";
        String MENSAGEM_SENHAS_NAO_CONFEREM_TITULO = "Senhas não conferem.";
        String MENSAGEM_SENHAS_NAO_CONFEREM_DETALHES = "A senha e sua confirmação devem ser iguais.";
        String MENSAGEM_SUCESSO_INATIVAR_USUARIO = "Usuario Inativado com Sucesso!";
        String MENSAGEM_ERRO_INATIVAR_USUARIO = "Erro ao Inativar o Usuario";
        String MENSAGEM_SUCESSO_ATIVAR_USUARIO = "Usuario Ativado com Sucesso!";
        String MENSAGEM_ERRO_ATIVAR_USUARIO = "Erro ao Ativar o Usuario";
        String MENSAGEM_SUCESSO_EXCLUIR_USUARIO = "Usuario Excluir com Sucesso!";
        String MENSAGEM_ERRO_EXCLUIR_USUARIO = "Erro ao Excluir o Usuario";
        String MENSAGEM_SUCESSO_CADASTRAR_USUARIO = "Cadastro Realizado com sucesso";
        String MENSAGEM_ERRO_CADASTRAR_USUARIO = "Erro ao Cadastrar Usuario";
        String MENSAGEM_SUCESSO_ALTERAR_USUARIO = "Usuario alterado com sucesso";
        String MENSAGEM_ERRO_ALTERAR_USUARIO = "Erro ao alterar Usuario";
        String MENSAGEM_ERRO_LISTAR_USUARIOS = "Erro ao listar Usuarios";
    }

    interface outros {
        String USUARIO_DA_SESSAO = "user_session";
        String FORM = "form";
        String DLG = "dlg";
    }

    interface dialogs {
        String DIALOG_CADASTRAR_SENHA = "dlgCadastrarSenha";
        String DIALOG_CONFIRMAR_INATIVAR_USUARIO = "dlgConfirmarInativarUsuario";
        String DIALOG_CONFIRMAR_ATIVAR_USUARIO = "dlgConfirmarAtivarUsuario";
        String DIALOG_CONFIRMAR_EXCLUIR_USUARIO = "dlgConfirmarExcluirUsuario";
        String DIALOG_ALTERAR_USUARIO = "dlgAlterarUsuario";
    }

    interface nomeDialog{
        String NOME_DIALOG_CADASTRAR_SENHA = "CadastrarSenha";
        String NOME_DIALOG_CONFIRMAR_INATIVAR_USUARIO = "ConfirmarInativarUsuario";
        String NOME_DIALOG_CONFIRMAR_ATIVAR_USUARIO = "ConfirmarAtivarUsuario";
        String NOME_DIALOG_CONFIRMAR_EXCLUIR_USUARIO = "ConfirmarExcluirUsuario";
        String NOME_DIALOG_ALTERAR_USUARIO = "AlterarUsuario";
        String NOME_DIALOG_LISTAR_GENERO = "ListarGeneros";
    }

    interface form {
        String FORM_USUARIOS = "formUsuarios";
        String FORM_CONFIRMAR_INATIVAR_USUARIO  = "formConfirmarInativarUsuario";
        String FORM_CONFIRMAR_ATIVAR_USUARIO  = "formConfirmarAtivarUsuario";
        String FORM_CONFIRMAR_EXCLUIR_USUARIO  = "formConfirmarExcluirUsuario";
        String FORM_ALTERAR_USUARIO = "formAlterarUsuario";
    }

    interface pagina {
        String PAGINA_PRINCPAL = "principal";
        String PAGINA_LOGIN = "login";
        String PAGINA_USUARIOS = "usuarios";
    }

}
