package br.edu.cesmac.si.noticia.service;

import br.edu.cesmac.si.noticia.domain.Usuario;
import br.edu.cesmac.si.noticia.enums.ModeloPerfil;
import br.edu.cesmac.si.noticia.repository.UsuarioJPA;
import br.edu.cesmac.si.noticia.util.MensagemUtil;
import br.edu.cesmac.si.noticia.util.VerificadorUtil;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static br.edu.cesmac.si.noticia.shared.Constantes.Constantes.mensagems.*;

public class UsuarioService {
    private UsuarioJPA usuarioJPA;

    public UsuarioService() {
        this.usuarioJPA = new UsuarioJPA();
    }

    public void cadastrar(Usuario usuario){
        usuario.setIdPerfil(ModeloPerfil.LEITOR.getCodigo());
        try{
            retirarMascaras(usuario);
            usuario.setAtivo(true);
            usuarioJPA.cadastrar(usuario);
            MensagemUtil.sucesso(MENSAGEM_SUCESSO_CADASTRAR_USUARIO);
        }catch (Exception e){
            MensagemUtil.erro(MENSAGEM_ERRO_CADASTRAR_USUARIO, e.getMessage());
        }
    }

    private void retirarMascaras(Usuario usuario) {
        usuario.setCelular(usuario.getCelular().replaceAll("[.-]", ""));
        usuario.setCpf(usuario.getCpf().replaceAll("[.-]", ""));
    }

    public boolean alterar(Usuario usuario){
        try{
            retirarMascaras(usuario);
            usuarioJPA.alterar(usuario);
            return true;
        }catch (Exception e){
            MensagemUtil.erro(MENSAGEM_ERRO_ALTERAR_USUARIO, e.getMessage());
            return false;
        }
    }

    public boolean inativarUsuario(Usuario usuario){
        try{
            usuario.setAtivo(false);
            usuarioJPA.alterar(usuario);
            return true;
        }catch (Exception e){
            MensagemUtil.erro(MENSAGEM_ERRO_INATIVAR_USUARIO, e.getMessage());
            return false;
        }
    }

    public boolean ativarUsuario(Usuario usuario){
        try{
            usuario.setAtivo(true);
            usuarioJPA.alterar(usuario);
            return true;
        }catch (Exception e){
            MensagemUtil.erro(MENSAGEM_ERRO_ATIVAR_USUARIO, e.getMessage());
            return false;
        }
    }

    public boolean excluirUsuario(Usuario usuario){
        try{
            usuarioJPA.remover(usuario);
            return true;
        }catch (Exception e){
            MensagemUtil.erro(MENSAGEM_ERRO_EXCLUIR_USUARIO, e.getMessage());
            return false;
        }
    }

    public List<Usuario> retonarListaUsuarios(){
        try{
            return usuarioJPA.listar();
        }catch (Exception e){
            MensagemUtil.erro(MENSAGEM_ERRO_LISTAR_USUARIOS, e.getMessage());
            return null;
        }
    }
}
