package br.edu.cesmac.si.noticia.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity(name = "nota_filme")
public class NotaFilme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double nota;
    @Column(name = "id_filme")
    private Integer idFilme;
    @Column(name = "id_usuario")
    private Integer idUsuario;

    public NotaFilme(Double nota, Integer idFilme, Integer idUsuario) {
        this.nota = nota;
        this.idFilme = idFilme;
        this.idUsuario = idUsuario;
    }

    public NotaFilme() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Integer idFilme) {
        this.idFilme = idFilme;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotaFilme notaFilme = (NotaFilme) o;
        return Objects.equals(id, notaFilme.id) &&
                Objects.equals(nota, notaFilme.nota) &&
                Objects.equals(idFilme, notaFilme.idFilme) &&
                Objects.equals(idUsuario, notaFilme.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nota, idFilme, idUsuario);
    }

    @Override
    public String toString() {
        return "NotaFilme{" +
                "id=" + id +
                ", nota=" + nota +
                ", idFilme=" + idFilme +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
