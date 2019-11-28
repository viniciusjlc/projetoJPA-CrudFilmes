package br.edu.cesmac.si.noticia.enums;

public enum ModeloFuncaoProducao {
    ATOR(1, "Ator"),
    DIRETOR(2, "Diretor"),
    PRODUTOR(3, "Produtor");

    private Integer codigo;
    private String descricao;

    ModeloFuncaoProducao(Integer codigo, String descricao){
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
