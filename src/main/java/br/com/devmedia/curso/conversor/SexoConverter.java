package br.com.devmedia.curso.conversor;

import org.springframework.core.convert.converter.Converter;

import br.com.devmedia.curso.domain.Sexo;

public class SexoConverter implements Converter<String, Sexo> {

	@Override
	public Sexo convert(String texto) {
		char tipo = texto.charAt(0);
		return tipo == Sexo.FEMININO.getDescricao() ? Sexo.FEMININO : Sexo.MASCULINO;
	}

}
