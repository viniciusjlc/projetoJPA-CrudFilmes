package br.edu.cesmac.si.noticia.service;

import br.edu.cesmac.si.noticia.domain.Filme;
import br.edu.cesmac.si.noticia.domain.MembroProducao;
import br.edu.cesmac.si.noticia.repository.FilmeJPA;
import br.edu.cesmac.si.noticia.repository.MembrosProducaoJPA;
import br.edu.cesmac.si.noticia.util.MensagemUtil;

import java.util.List;

public class FilmeService {
    FilmeJPA filmeJPA;

    public FilmeService() {
        this.filmeJPA = new FilmeJPA();
    }

    public List<Filme> listar(){
        return filmeJPA.listar();
    }

    public boolean cadastrar(Filme filme){
        try{
            filmeJPA.cadastrar(filme);
            return true;
        }catch (Exception e){
            MensagemUtil.erro("Erro ao Cadastrar Filme", e.getLocalizedMessage());
            return false;
        }
    }

    public boolean alterar(Filme filme){
        try{
            filmeJPA.alterar(filme);
            return true;
        }catch (Exception e){
            MensagemUtil.erro("Erro ao Alterar Filme", e.getLocalizedMessage());
            return false;
        }
    }

    public boolean excluir(Filme filme){
        try{
            filmeJPA.remover(filme);
            return true;
        }catch (Exception e){
            MensagemUtil.erro("Erro ao Excluir Filme", e.getLocalizedMessage());
            return false;
        }
    }

    public List<MembroProducao> listarMembrosProducaoNaoFilme(List<MembroProducao> listaMembrosFilme){
        return new MembrosProducaoJPA().listarMembrosForaFilme(listaMembrosFilme);
    }

    public Double retornarNota(Integer idFilme){
        return filmeJPA.retornarNota(idFilme);
    }
}
