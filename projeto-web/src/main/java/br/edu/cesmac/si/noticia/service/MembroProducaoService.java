package br.edu.cesmac.si.noticia.service;

import br.edu.cesmac.si.noticia.domain.MembroProducao;
import br.edu.cesmac.si.noticia.repository.MembrosProducaoJPA;
import br.edu.cesmac.si.noticia.util.MensagemUtil;

import java.util.List;

public class MembroProducaoService {
    MembrosProducaoJPA membrosProducaoJPA;

    public MembroProducaoService() {
        this.membrosProducaoJPA = new MembrosProducaoJPA();
    }

    public List<MembroProducao> listar(){
        return membrosProducaoJPA.listar();
    }

    public boolean cadastrar(MembroProducao membroProducao){
        try{
            membrosProducaoJPA.cadastrar(membroProducao);
            return true;
        }catch (Exception e){
            MensagemUtil.erro("Erro ao Cadastrar Membro Produção", e.getLocalizedMessage());
            return false;
        }
    }

    public boolean alterar(MembroProducao membroProducao){
        try{
            membrosProducaoJPA.alterar(membroProducao);
            return true;
        }catch (Exception e){
            MensagemUtil.erro("Erro ao Alterar Membro Produção", e.getLocalizedMessage());
            return false;
        }
    }

    public boolean excluir(MembroProducao membroProducao){
        try{
            membrosProducaoJPA.remover(membroProducao);
            return true;
        }catch (Exception e){
            MensagemUtil.erro("Erro ao Excluir Membro Produção", e.getLocalizedMessage());
            return false;
        }
    }

}
