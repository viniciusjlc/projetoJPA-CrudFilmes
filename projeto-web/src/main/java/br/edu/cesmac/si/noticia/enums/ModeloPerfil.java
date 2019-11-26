package br.edu.cesmac.si.noticia.enums;

public enum ModeloPerfil {

    LEITOR(1, "Leitor"),
    ESCRITOR(2, "Escritor"),
    MODERADOR(3, "Moderador"),
    ADMINISTRADOR(4, "Administrador");

    private Integer codigo;
    private String descricao;

    ModeloPerfil(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }


}
