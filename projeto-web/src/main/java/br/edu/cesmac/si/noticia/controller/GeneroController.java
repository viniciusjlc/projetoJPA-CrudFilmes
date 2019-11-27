package br.edu.cesmac.si.noticia.controller;

import br.edu.cesmac.si.noticia.domain.Genero;
import br.edu.cesmac.si.noticia.service.GeneroService;
import br.edu.cesmac.si.noticia.util.VerificadorUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean(name = "generoMB")
public class GeneroController {
    private GeneroService generoService;
    private List<Genero> generos = new ArrayList<>();

    public GeneroController() {
        this.generoService = new GeneroService();
    }

    public List<Genero> getGeneros() {
        return (!generos.isEmpty()) ? generos : generoService.listarGeneros();
    }
}
