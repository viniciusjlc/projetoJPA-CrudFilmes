package br.edu.cesmac.si.noticia.controller;

import br.edu.cesmac.si.noticia.domain.Filme;
import br.edu.cesmac.si.noticia.domain.MembroProducao;
import br.edu.cesmac.si.noticia.domain.NotaFilme;
import br.edu.cesmac.si.noticia.enums.ModeloClassificacoesIndicativas;
import br.edu.cesmac.si.noticia.service.FilmeService;
import br.edu.cesmac.si.noticia.util.MensagemUtil;
import br.edu.cesmac.si.noticia.util.PagesUtil;
import br.edu.cesmac.si.noticia.util.SessaoUtil;
import br.edu.cesmac.si.noticia.util.VerificadorUtil;

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
    private List<MembroProducao> listaOutrosMembros;
    private MembroProducao membroProducao;
    private Integer nota;

    public FilmeController() {
        this.filmeService = new FilmeService();
        this.filme = new Filme();
        this.listaOutrosMembros = null;
    }

    public List<Filme> getFilmes() {
        return (!filmes.isEmpty()) ? filmes : filmeService.listar();
    }

    public List<MembroProducao> getListaOutrosMembros() {
        if (VerificadorUtil.estaNulo(listaOutrosMembros)) {
            listaOutrosMembros = filmeService.listarMembrosProducaoNaoFilme(filme.getMembrosProducao());
        }
        return listaOutrosMembros;
    }

    public void cadastrar() {
        if (filmeService.cadastrar(filme)) {
            MensagemUtil.sucesso("Filme cadastrado com sucesso!");
            fecharDialogCadastrar();
        }
    }

    public void alterar() {
        if (filmeService.alterar(filme)) {
            MensagemUtil.sucesso("Filme alterado com sucesso!");
            fecharDialogAlterar();
        }
    }

    public void excluir() {
        if (filmeService.excluir(filme)) {
            MensagemUtil.sucesso("Filme excluido com sucesso!");
            fecharDialogExcluir();
        }
    }

    public void atualizarElenco(){
        if(filmeService.alterar(filme)){
            MensagemUtil.sucesso("Elenco atualizado com sucesso!");
            fecharDialogVisualizarProducao();
        }
    }

    public void avaliar() {
        NotaFilme notaFilme = new NotaFilme(Double.valueOf(nota), filme.getId(), new SessaoController().getUsuarioSessao().getId());
        if (filmeService.avaliar(notaFilme)) {
            MensagemUtil.sucesso("Filme avaliado com sucesso!");
            nota = null;
            fecharDialogAvaliar();
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

    public void abrirDialogAvaliar() {
        PagesUtil.abrirDialogAtualizado("AvaliarFilme");
    }

    public void abrirDialogVisualizarProducao() {
        listaOutrosMembros = filmeService.listarMembrosProducaoNaoFilme(filme.getMembrosProducao());
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
        PagesUtil.fecharDialog("dlgVisualizarProducao");
        PagesUtil.atualizarComponente(FORM_FILME);
    }

    public void fecharDialogAvaliar() {
        filme = new Filme();
        PagesUtil.fecharDialog("dlgAvaliarFilme");
        PagesUtil.atualizarComponente(FORM_FILME);
    }

    public void adicionarMembroFilme(MembroProducao membroProducao) {
        filme.getMembrosProducao().add(membroProducao);
        listaOutrosMembros.remove(membroProducao);
    }

    public void retirarMembroFilme(MembroProducao membroProducao) {
        listaOutrosMembros.add(membroProducao);
        filme.getMembrosProducao().remove(membroProducao);
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Double retornarNota(Integer idFilme){
        return filmeService.retornarNota(idFilme, new SessaoController().getUsuarioSessao().getId());
    }

    public Double retornarNotaGeral(Integer idFilme){
        return filmeService.retornarNotaGeral(idFilme);
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public List<Integer> getListaValoresNota(){
        List<Integer> listaValoresNota = new ArrayList<>();
        for(int i=1; i<=10;i++){
            listaValoresNota.add(i);
        }
        return listaValoresNota;
    }
}
