package br.edu.cesmac.si.noticia.controller;

import br.edu.cesmac.si.noticia.domain.Usuario;
import br.edu.cesmac.si.noticia.enums.ModeloPerfil;
import br.edu.cesmac.si.noticia.repository.SessaoJPA;
import br.edu.cesmac.si.noticia.shared.DTOs.ParametrosLoginDTO;
import br.edu.cesmac.si.noticia.util.MensagemUtil;
import br.edu.cesmac.si.noticia.util.PagesUtil;
import br.edu.cesmac.si.noticia.util.SessaoUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import static br.edu.cesmac.si.noticia.shared.Constantes.Constantes.mensagems.*;
import static br.edu.cesmac.si.noticia.shared.Constantes.Constantes.nomeDialog.*;
import static br.edu.cesmac.si.noticia.shared.Constantes.Constantes.outros.*;
import static br.edu.cesmac.si.noticia.shared.Constantes.Constantes.pagina.*;
import static br.edu.cesmac.si.noticia.util.VerificadorUtil.*;
import static br.edu.cesmac.si.noticia.util.SessaoUtil.*;

@ViewScoped
@ManagedBean(name = "sessaoMB")
public class SessaoController {
    private ParametrosLoginDTO parametrosLoginDTO;
    private Usuario usuarioSessao = retornarUsuarioDaSessao();

    public SessaoController() {
        this.parametrosLoginDTO = new ParametrosLoginDTO();
    }

    public void sair(){
        usuarioSessao = null;
        SessaoUtil.excluirVariavelDaSessao(USUARIO_DA_SESSAO);
        controleSessao();
    }

    public void verificarUsuario() {
        Usuario usuario = new SessaoJPA().verificarUsuario(parametrosLoginDTO);
        if (naoEstaNulo(usuario)) {
            colocarVariavelNaSessao(USUARIO_DA_SESSAO, usuario);
            redirecionarPrincipal();
        } else {
            MensagemUtil.alerta(MENSAGEM_LOGIN_INVALIDO_TITULO, MENSAGEM_LOGIN_INVALIDO_DETALHES);
        }
    }

    public Boolean permissaoEscritor(){
        controleSessao();
        return ModeloPerfil.ESCRITOR.getCodigo()<=usuarioSessao.getIdPerfil();
    }

    public Boolean permissaoModerador(){
        controleSessao();return ModeloPerfil.MODERADOR.getCodigo()<=usuarioSessao.getIdPerfil();
    }

    public Boolean permissaoAdministrador(){
        controleSessao();
        return ModeloPerfil.ADMINISTRADOR.getCodigo()<=usuarioSessao.getIdPerfil();
    }

    public void abrirDialogListarGeneros(){
        PagesUtil.abrirDialogAtualizado(NOME_DIALOG_LISTAR_GENERO);
    }

    public void abrirDialogListarMembrosProducao(){
        PagesUtil.abrirDialogAtualizado("ListarMembrosProducao");
    }

    public void controleSessao(){
        if(estaNulo(usuarioSessao)) redirecionarLogin();
    }

    public void redirecionarLogin() {
        PagesUtil.redirectPage(PAGINA_LOGIN);
    }

    public void redirecionarPrincipal() {
        PagesUtil.redirectPage(PAGINA_PRINCPAL);
    }

    public void redirecionarUsuario() {
        PagesUtil.redirectPage(PAGINA_USUARIOS);
    }


    public void redirecionarFilmes() {
        PagesUtil.redirectPage(PAGINA_FILMES);
    }

    public ParametrosLoginDTO getParametrosLoginDTO() {
        return parametrosLoginDTO;
    }

    public void setParametrosLoginDTO(ParametrosLoginDTO parametrosLoginDTO) {
        this.parametrosLoginDTO = parametrosLoginDTO;
    }

    public Usuario getUsuarioSessao() {
        return usuarioSessao;
    }

    public void setUsuarioSessao(Usuario usuarioSessao) {
        this.usuarioSessao = usuarioSessao;
    }
}
