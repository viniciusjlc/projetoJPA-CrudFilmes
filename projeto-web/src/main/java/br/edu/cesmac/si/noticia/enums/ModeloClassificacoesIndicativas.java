package br.edu.cesmac.si.noticia.enums;

public enum ModeloClassificacoesIndicativas {
    LIVRE(1, "Livre", "Recomendado para todas as idades.", "VERDE", ""),
    NAO_RECOMENDADO_10(2, "10 Anos", "Não Recomendado para menores de 10 anos", "AZUL", ""),
    NAO_RECOMENDADO_12(3, "12 Anos", "Não Recomendado para menores de 12 anos", "AMARELO", ""),
    NAO_RECOMENDADO_14(4, "14 Anos", "Não Recomendado para menores de 14 anos", "LARANJA", ""),
    NAO_RECOMENDADO_16(5, "16 Anos", "Não Recomendado para menores de 16 anos", "VERMELHO", ""),
    PROIBIDO_18(6, "16 Anos", "Proibido para menores de 18 anos", "PRETO", "");

    private Integer codigo;
    private String descricao;
    private String descricaoResumida;
    private String cor;
    private String codigoCor;

    ModeloClassificacoesIndicativas(Integer codigo, String descricao, String descricaoResumida, String cor, String codigoCor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.descricaoResumida = descricaoResumida;
        this.cor = cor;
        this.codigoCor = codigoCor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDescricaoResumida() {
        return descricaoResumida;
    }

    public String getCor() {
        return cor;
    }

    public String getCodigoCor() {
        return codigoCor;
    }
}
