package br.edu.cesmac.si.noticia.domain;

import javax.persistence.*;
import java.util.List;

@Entity(name = "membros_producao")
public class MembroProducao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome_ator")
    private String nomeAtor;
    @Column(name = "nome_personagem")
    private String nomePersonagem;
    @OneToOne
    @JoinColumn (name = "id_funcao")
    private FuncaoProducao funcaoProducao;
    @ManyToMany (fetch = FetchType.EAGER)
    private List<Filme> filmes;

}
