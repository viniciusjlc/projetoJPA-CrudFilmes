package br.edu.cesmac.si.noticia.controller;

import br.edu.cesmac.si.noticia.domain.MembroProducao;
import br.edu.cesmac.si.noticia.enums.ModeloFuncaoProducao;
import br.edu.cesmac.si.noticia.service.MembroProducaoService;
import br.edu.cesmac.si.noticia.util.MensagemUtil;
import br.edu.cesmac.si.noticia.util.PagesUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ViewScoped
@ManagedBean(name = "membrosProducaoMB")
public class MembrosProducaoController {
    private MembroProducaoService membrosProducaoService;
    private List<MembroProducao> membrosProducao;
    private MembroProducao membroProducao;

    private List<ModeloFuncaoProducao> listaFuncaoProducao;

    public MembrosProducaoController() {
        this.membrosProducaoService = new MembroProducaoService();
        this.membrosProducao = new ArrayList<>();
        this.membroProducao = new MembroProducao();
        this.listaFuncaoProducao = Arrays.asList(ModeloFuncaoProducao.values());
    }

    public List<MembroProducao> getMembrosProducao() {
        return (membrosProducao.isEmpty()) ? membrosProducaoService.listar() : membrosProducao;
    }

    public void cadastrar() {
        if (membrosProducaoService.cadastrar(membroProducao)) {
            membroProducao = new MembroProducao();
            MensagemUtil.sucesso("Membro produção cadastrado com sucesso!");
            PagesUtil.fecharDialog("dlgCadastrarMembroProducao");
            PagesUtil.abrirDialogAtualizado("ListarMembrosProducao");
        }
    }

    public void alterar() {
        if (membrosProducaoService.alterar(membroProducao)) {
            membroProducao = new MembroProducao();
            MensagemUtil.sucesso("Membro produção alterado com sucesso!");
            PagesUtil.fecharDialog("dlgAlterarMembroProducao");
            PagesUtil.abrirDialogAtualizado("ListarMembrosProducao");
        }
    }

    public void excluir() {
        if (membrosProducaoService.excluir(membroProducao)) {
            membroProducao = new MembroProducao();
            MensagemUtil.sucesso("Membro produção excluido com sucesso!");
            PagesUtil.fecharDialog("dlgExcluirMembroProducao");
            PagesUtil.abrirDialogAtualizado("ListarMembrosProducao");
        }
    }

    public void abrirDialogCadastrar() {
        PagesUtil.fecharDialog("dlgListarMembrosProducao");
        PagesUtil.abrirDialogAtualizado("CadastrarMembroProducao");
    }

    public void abrirDialogAlterar() {
        PagesUtil.fecharDialog("dlgListarMembrosProducao");
        PagesUtil.abrirDialogAtualizado("AlterarMembroProducao");
    }

    public void abrirDialogExcluir() {
        PagesUtil.fecharDialog("dlgListarMembrosProducao");
        PagesUtil.abrirDialogAtualizado("ExcluirMembroProducao");
    }

    public void fecharDialogCadastrar() {
        membroProducao = new MembroProducao();
        PagesUtil.fecharDialog("dlgCadastrarMembroProducao");
        PagesUtil.abrirDialog("dlgListarMembrosProducao");
    }


    public void fecharDialogAlterar() {
        membroProducao = new MembroProducao();
        PagesUtil.fecharDialog("dlgAlterarMembroProducao");
        PagesUtil.abrirDialog("dlgListarMembrosProducao");
    }

    public void fecharDialogExcluir() {
        membroProducao = new MembroProducao();
        PagesUtil.fecharDialog("dlgExcluirMembroProducao");
        PagesUtil.abrirDialog("dlgListarMembrosProducao");
    }

    public void setMembrosProducao(List<MembroProducao> membrosProducao) {
        this.membrosProducao = membrosProducao;
    }

    public MembroProducao getMembroProducao() {
        return membroProducao;
    }

    public void setMembroProducao(MembroProducao membroProducao) {
        this.membroProducao = membroProducao;
    }

    public MembroProducaoService getMembrosProducaoService() {
        return membrosProducaoService;
    }

    public void setMembrosProducaoService(MembroProducaoService membrosProducaoService) {
        this.membrosProducaoService = membrosProducaoService;
    }

    public List<ModeloFuncaoProducao> getListaFuncaoProducao() {
        return listaFuncaoProducao;
    }

    public void setListaFuncaoProducao(List<ModeloFuncaoProducao> listaFuncaoProducao) {
        this.listaFuncaoProducao = listaFuncaoProducao;
    }
}
