package br.edu.cesmac.si.noticia.controller;

import br.edu.cesmac.si.noticia.domain.Filme;
import br.edu.cesmac.si.noticia.enums.ModeloClassificacoesIndicativas;
import br.edu.cesmac.si.noticia.service.FilmeService;
import br.edu.cesmac.si.noticia.util.MensagemUtil;
import br.edu.cesmac.si.noticia.util.PagesUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static br.edu.cesmac.si.noticia.shared.Constantes.Constantes.outros.FORM_FILME;

@ViewScoped
@ManagedBean(name = "filmeMB")
public class FilmeController {
    private FilmeService filmeService;
    private List<Filme> filmes = new ArrayList<>();
    private Filme filme;

    public FilmeController() {
        this.filmeService = new FilmeService();
        this.filme = new Filme();
    }

    public List<Filme> getFilmes() {
        return (!filmes.isEmpty()) ? filmes : filmeService.listar();
    }

    public void cadastrar() {
        if (filmeService.cadastrar(filme)) {
            filme = new Filme();
            MensagemUtil.sucesso("Filme cadastrado com sucesso!");
            PagesUtil.fecharDialog("dlgCadastrarFilme");
            PagesUtil.atualizarComponente(FORM_FILME);
        }
    }

    public void alterar() {
        if (filmeService.alterar(filme)) {
            filme = new Filme();
            MensagemUtil.sucesso("Filme alterado com sucesso!");
            PagesUtil.fecharDialog("dlgAlterarFilme");
            PagesUtil.atualizarComponente(FORM_FILME);
        }
    }

    public void excluir() {
        if (filmeService.excluir(filme)) {
            filme = new Filme();
            MensagemUtil.sucesso("Filme excluido com sucesso!");
            PagesUtil.fecharDialog("dlgExcluirFilme");
            PagesUtil.atualizarComponente(FORM_FILME);
        }
    }

    public List<ModeloClassificacoesIndicativas> getClassificacoesIndicativas() {
        return Arrays.asList(ModeloClassificacoesIndicativas.values());
    }

    public void abrirDialogCadastrar() {
        PagesUtil.abrirDialogAtualizado("CadastrarFilme");
    }


    public void abrirDialogAlterar() {
        PagesUtil.abrirDialogAtualizado("AlterarFilme");
    }


    public void abrirDialogExcluir() {
        PagesUtil.abrirDialogAtualizado("ExcluirFilme");
    }

    public void abrirDialogVisualizarProducao() {
        PagesUtil.abrirDialogAtualizado("VisualizarProducao");
    }

    public void fecharDialogCadastrar() {
        filme = new Filme();
        PagesUtil.fecharDialog("dlgCadastrarFilme");
        PagesUtil.atualizarComponente(FORM_FILME);
    }

    public void fecharDialogAlterar() {
        filme = new Filme();
        PagesUtil.fecharDialog("dlgAlterarFilme");
        PagesUtil.atualizarComponente(FORM_FILME);
    }

    public void fecharDialogExcluir() {
        filme = new Filme();
        PagesUtil.fecharDialog("dlgExcluirFilme");
        PagesUtil.atualizarComponente(FORM_FILME);
    }

    public void fecharDialogVisualizarProducao() {
        filme = new Filme();
        PagesUtil.fecharDialog("dlgVisualizarFilmeProducao");
        PagesUtil.atualizarComponente(FORM_FILME);
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

}
