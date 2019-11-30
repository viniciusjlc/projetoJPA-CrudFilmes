package br.edu.cesmac.si.noticia.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "filmes")
public class Filme implements Serializable, Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sinopse;
    @OneToOne
    @JoinColumn(name = "id_classificacao_indicativa")
    private ClassificacaoIndicativa classificacaoIndicativa;
    @OneToOne
    @JoinColumn(name = "id_categoria")
    private Genero genero;
    @ManyToMany (fetch = FetchType.LAZY)
    private List<MembroProducao> membrosProducao;

    public Filme() {
        this.classificacaoIndicativa = new ClassificacaoIndicativa();
        this.genero = new Genero();
        this.membrosProducao = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ClassificacaoIndicativa getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(ClassificacaoIndicativa classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<MembroProducao> getMembrosProducao() {
        return membrosProducao;
    }

    public void setMembrosProducao(List<MembroProducao> membrosProducao) {
        this.membrosProducao = membrosProducao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return Objects.equals(id, filme.id) &&
                Objects.equals(nome, filme.nome) &&
                Objects.equals(sinopse, filme.sinopse) &&
                Objects.equals(classificacaoIndicativa, filme.classificacaoIndicativa) &&
                Objects.equals(genero, filme.genero) &&
                Objects.equals(membrosProducao, filme.membrosProducao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sinopse, classificacaoIndicativa, genero, membrosProducao);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
