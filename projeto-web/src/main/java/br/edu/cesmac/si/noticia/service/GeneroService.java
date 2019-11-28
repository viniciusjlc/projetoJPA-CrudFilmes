package br.edu.cesmac.si.noticia.service;

import br.edu.cesmac.si.noticia.domain.Genero;
import br.edu.cesmac.si.noticia.repository.GeneroJPA;
import br.edu.cesmac.si.noticia.util.MensagemUtil;

import java.util.List;

public class GeneroService {
    private GeneroJPA generoJPA;

    public GeneroService() {
        generoJPA = new GeneroJPA();
    }

    public List<Genero> listarGeneros(){
        return generoJPA.listar();
    }

    public boolean cadastrar(Genero genero){
        try{
            generoJPA.cadastrar(genero);
            return true;
        }catch (Exception e){
            MensagemUtil.erro("Erro ao Cadastrar Gênero", e.getLocalizedMessage());
            return false;
        }
    }

    public boolean alterar(Genero genero){
        try{
            generoJPA.alterar(genero);
            return true;
        }catch (Exception e){
            MensagemUtil.erro("Erro ao Alterar Gênero", e.getLocalizedMessage());
            return false;
        }
    }

    public boolean excluir(Genero genero){
        try{
            generoJPA.remover(genero);
            return true;
        }catch (Exception e){
            MensagemUtil.erro("Erro ao Excluir Gênero", e.getLocalizedMessage());
            return false;
        }
    }
}
