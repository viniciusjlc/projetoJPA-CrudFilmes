package br.edu.cesmac.si.noticia.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "membros_producao")
public class MembroProducao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome_ator")
    private String nomeAtor;
    @OneToOne
    @JoinColumn (name = "id_funcao")
    private FuncaoProducao funcaoProducao;
    @ManyToMany (fetch = FetchType.LAZY)
    private List<Filme> filmes;

    public MembroProducao() {
        this.funcaoProducao = new FuncaoProducao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeAtor() {
        return nomeAtor;
    }

    public void setNomeAtor(String nomeAtor) {
        this.nomeAtor = nomeAtor;
    }

    public FuncaoProducao getFuncaoProducao() {
        return funcaoProducao;
    }

    public void setFuncaoProducao(FuncaoProducao funcaoProducao) {
        this.funcaoProducao = funcaoProducao;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
}
