package br.edu.cesmac.si.noticia.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "classificacoes_indicativas")
public class ClassificacaoIndicativa implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    @Column(name = "descricao_resumida")
    private String descricaoResumida;
    private String cor;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoResumida() {
        return descricaoResumida;
    }

    public void setDescricaoResumida(String descricaoResumida) {
        this.descricaoResumida = descricaoResumida;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassificacaoIndicativa that = (ClassificacaoIndicativa) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(descricao, that.descricao) &&
                Objects.equals(descricaoResumida, that.descricaoResumida) &&
                Objects.equals(cor, that.cor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, descricaoResumida, cor);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
