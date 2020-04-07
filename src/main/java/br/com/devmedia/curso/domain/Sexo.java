package br.com.devmedia.curso.domain;

public enum Sexo {
	FEMININO('F'),MASCULINO('M');

	private char descricao;
	
	private Sexo(char descricao) {
		this.setDescricao(descricao);
	}

	public char getDescricao() {
		return descricao;
	}

	public void setDescricao(char descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.getDescricao());
	}
	
}
