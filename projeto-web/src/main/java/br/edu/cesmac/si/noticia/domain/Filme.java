package br.edu.cesmac.si.noticia.domain;

import br.edu.cesmac.si.noticia.repository.FilmeJPA;
import br.edu.cesmac.si.noticia.util.VerificadorUtil;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "membros_filme", joinColumns = {
            @JoinColumn(name = "id_filme", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_membro", referencedColumnName = "id")})
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


}
