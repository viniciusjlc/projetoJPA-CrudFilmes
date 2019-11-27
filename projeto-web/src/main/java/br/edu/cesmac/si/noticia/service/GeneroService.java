package br.edu.cesmac.si.noticia.service;

import br.edu.cesmac.si.noticia.domain.Genero;
import br.edu.cesmac.si.noticia.repository.GeneroJPA;

import java.util.List;

public class GeneroService {
    private GeneroJPA generoJPA;

    public GeneroService() {
        generoJPA = new GeneroJPA();
    }

    public List<Genero> listarGeneros(){
        return generoJPA.listar();
    }
}
