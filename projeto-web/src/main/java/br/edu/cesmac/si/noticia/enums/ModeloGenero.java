package br.edu.cesmac.si.noticia.enums;

public enum ModeloGenero {
	MASCULINO("M"),
	FEMININO("F");

	private String sigla;

	ModeloGenero(String sigla){
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}
}
