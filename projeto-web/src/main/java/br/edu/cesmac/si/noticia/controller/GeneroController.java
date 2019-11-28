package br.edu.cesmac.si.noticia.controller;

import br.edu.cesmac.si.noticia.domain.Genero;
import br.edu.cesmac.si.noticia.service.GeneroService;
import br.edu.cesmac.si.noticia.util.MensagemUtil;
import br.edu.cesmac.si.noticia.util.PagesUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

import static br.edu.cesmac.si.noticia.shared.Constantes.Constantes.nomeDialog.NOME_DIALOG_LISTAR_GENERO;

@ViewScoped
@ManagedBean(name = "generoMB")
public class GeneroController {
    private GeneroService generoService;
    private List<Genero> generos = new ArrayList<>();
    private Genero genero;

    public GeneroController() {
        this.generoService = new GeneroService();
        this.genero = new Genero();
    }

    public List<Genero> getGeneros() {
        return (!generos.isEmpty()) ? generos : generoService.listarGeneros();
    }

    public void cadastrar() {
        if (generoService.cadastrar(genero)) {
            genero = new Genero();
            MensagemUtil.sucesso("Gênero cadastrado com sucesso!");
            PagesUtil.fecharDialog("dlgCadastrarGenero");
            PagesUtil.abrirDialogAtualizado(NOME_DIALOG_LISTAR_GENERO);
        }
    }

    public void alterar() {
        if (generoService.alterar(genero)) {
            genero = new Genero();
            MensagemUtil.sucesso("Gênero alterado com sucesso!");
            PagesUtil.fecharDialog("dlgAlterarGenero");
            PagesUtil.abrirDialogAtualizado(NOME_DIALOG_LISTAR_GENERO);
        }
    }

    public void excluir() {
        if (generoService.excluir(genero)) {
            genero = new Genero();
            MensagemUtil.sucesso("Gênero excluido com sucesso!");
            PagesUtil.fecharDialog("dlgExcluirGenero");
            PagesUtil.abrirDialogAtualizado(NOME_DIALOG_LISTAR_GENERO);
        }
    }

    public void abrirDialogCadastrar() {
        PagesUtil.fecharDialog("dlgListarGeneros");
        PagesUtil.abrirDialogAtualizado("CadastrarGenero");
    }


    public void abrirDialogAlterar() {
        PagesUtil.fecharDialog("dlgListarGeneros");
        PagesUtil.abrirDialogAtualizado("AlterarGenero");
    }


    public void abrirDialogExcluir() {
        PagesUtil.fecharDialog("dlgListarGeneros");
        PagesUtil.abrirDialogAtualizado("ExcluirGenero");
    }

    public void fecharDialogCadastrar(){
        genero = new Genero();
        PagesUtil.fecharDialog("dlgCadastrarGenero");
        PagesUtil.abrirDialog("dlgListarGeneros");
    }

    public void fecharDialogAlterar(){
        genero = new Genero();
        PagesUtil.fecharDialog("dlgAlterarGenero");
        PagesUtil.abrirDialog("dlgListarGeneros");
    }

    public void fecharDialogExcluir(){
        genero = new Genero();
        PagesUtil.fecharDialog("dlgExcluirGenero");
        PagesUtil.abrirDialog("dlgListarGeneros");
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
