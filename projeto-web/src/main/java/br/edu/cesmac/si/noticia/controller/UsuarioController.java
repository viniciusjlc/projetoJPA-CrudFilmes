package br.edu.cesmac.si.noticia.controller;

import br.edu.cesmac.si.noticia.domain.Usuario;
import br.edu.cesmac.si.noticia.enums.ModeloGenero;
import br.edu.cesmac.si.noticia.enums.ModeloPerfil;
import br.edu.cesmac.si.noticia.service.UsuarioService;
import br.edu.cesmac.si.noticia.util.DataUtil;
import br.edu.cesmac.si.noticia.util.MensagemUtil;
import br.edu.cesmac.si.noticia.util.PagesUtil;
import br.edu.cesmac.si.noticia.util.SessaoUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static br.edu.cesmac.si.noticia.shared.Constantes.Constantes.dialogs.*;
import static br.edu.cesmac.si.noticia.shared.Constantes.Constantes.form.*;
import static br.edu.cesmac.si.noticia.shared.Constantes.Constantes.mensagems.*;
import static br.edu.cesmac.si.noticia.shared.Constantes.Constantes.nomeDialog.*;
import static br.edu.cesmac.si.noticia.shared.Constantes.Constantes.outros.*;
import static br.edu.cesmac.si.noticia.shared.Constantes.Constantes.pagina.*;
import static br.edu.cesmac.si.noticia.util.VerificadorUtil.naoEstaNuloOuVazio;

@ViewScoped
@ManagedBean(name = "usuarioMB")
public class UsuarioController {
    private Usuario usuario;
    private Usuario usuarioSelecionado;
    private String senhaConfirmar;
    private UsuarioService usuarioService;
    private List<Usuario> listaUsuarios;

    public UsuarioController() {
        this.usuario = new Usuario();
        this.usuarioSelecionado = new Usuario();
        this.usuarioService = new UsuarioService();
        this.listaUsuarios = null;
    }

    public void cadastrar() {
        if (usuario.getSenha().equals(senhaConfirmar)) {
            usuarioService.cadastrar(usuario);
            SessaoUtil.colocarVariavelNaSessao(USUARIO_DA_SESSAO, usuario);
            PagesUtil.redirectPage(PAGINA_PRINCPAL);
        } else {
            MensagemUtil.erro(MENSAGEM_SENHAS_NAO_CONFEREM_TITULO, MENSAGEM_SENHAS_NAO_CONFEREM_DETALHES);
        }
    }

    public void alterarUsuario() {
        if (usuarioService.alterar(usuarioSelecionado)) {
            MensagemUtil.sucesso(MENSAGEM_SUCESSO_ALTERAR_USUARIO);
            PagesUtil.fecharDialog(DIALOG_ALTERAR_USUARIO);
            PagesUtil.atualizarComponente(FORM_USUARIOS);
        }
    }

    public void inativarUsuario() {
        if (usuarioService.inativarUsuario(usuarioSelecionado)) {
            MensagemUtil.sucesso(MENSAGEM_SUCESSO_INATIVAR_USUARIO);
            PagesUtil.fecharDialog(DIALOG_CONFIRMAR_INATIVAR_USUARIO);
            PagesUtil.atualizarComponente(FORM_USUARIOS);
        }
    }

    public void ativarUsuario() {
        if (usuarioService.ativarUsuario(usuarioSelecionado)) {
            MensagemUtil.sucesso(MENSAGEM_SUCESSO_ATIVAR_USUARIO);
            PagesUtil.fecharDialog(DIALOG_CONFIRMAR_ATIVAR_USUARIO);
            PagesUtil.atualizarComponente(FORM_USUARIOS);
        }
    }

    public void excluirUsuario() {
        if (usuarioService.excluirUsuario(usuarioSelecionado)) {
            MensagemUtil.sucesso(MENSAGEM_SUCESSO_EXCLUIR_USUARIO);
            PagesUtil.fecharDialog(DIALOG_CONFIRMAR_EXCLUIR_USUARIO);
            PagesUtil.atualizarComponente(FORM_USUARIOS);
        }
    }

    public void abrirDialogSenha() {
        PagesUtil.abrirDialog(DIALOG_CADASTRAR_SENHA);
    }

    public void abrirDialogConfirmarInativarUsuario() {
        PagesUtil.abrirDialogAtualizado(NOME_DIALOG_CONFIRMAR_INATIVAR_USUARIO);
    }

    public void abrirDialogConfirmarAtivarUsuario() {
        PagesUtil.abrirDialogAtualizado(NOME_DIALOG_CONFIRMAR_ATIVAR_USUARIO);
    }

    public void abrirDialogConfirmarExcluirUsuario() {
        PagesUtil.abrirDialogAtualizado(NOME_DIALOG_CONFIRMAR_EXCLUIR_USUARIO);
    }

    public void abrirDialogAlterarUsuario() {
        PagesUtil.abrirDialogAtualizado(NOME_DIALOG_ALTERAR_USUARIO);
    }

    public List<ModeloGenero> getListaGenero() {
        return Arrays.asList(ModeloGenero.values());
    }

    public List<ModeloPerfil> getListaPefil() {
        List<ModeloPerfil> listaPefil = new ArrayList<>();
        for (ModeloPerfil modeloPerfil : Arrays.asList(ModeloPerfil.values())) {
            if (modeloPerfil.getCodigo() < ModeloPerfil.ADMINISTRADOR.getCodigo() || new SessaoController().permissaoAdministrador())
                listaPefil.add(modeloPerfil);
        }
        return listaPefil;
    }

    public String retornarNomePerfil(Integer idPerfil){
        for(ModeloPerfil modeloPerfil : Arrays.asList(ModeloPerfil.values())){
            if(modeloPerfil.getCodigo().equals(idPerfil)){
                return modeloPerfil.getDescricao();
            }
        }
        return "ERRO";
    }

    public Date getDataMaxima() {
        return DataUtil.getDataMaxima();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getSenhaConfirmar() {
        return senhaConfirmar;
    }

    public void setSenhaConfirmar(String senhaConfirmar) {
        this.senhaConfirmar = senhaConfirmar;
    }

    public List<Usuario> getListaUsuarios() {
        return (naoEstaNuloOuVazio(listaUsuarios) ? listaUsuarios : usuarioService.retonarListaUsuarios());
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }
}
