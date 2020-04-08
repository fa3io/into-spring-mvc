package br.com.devmedia.curso.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank
	@Size(min = 3 ,max = 50)
	private String nome;
	
	@NotBlank
	@Size(min = 3, max = 50, message = "Campo requerido entre {min} e {max} caracteres")
	private String sobrenome;
	
	@NotNull(message = "O campo 'Data De Nascimento' e requerido!")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;
	
	private Sexo sexo;
	
	public Usuario() {}
	
	public Usuario(Long id, String nome, String sobrenome) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
	
	}
	public Usuario(Long id, String nome, String sobrenome, LocalDate dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
	}
	
	

	public Usuario(Long id, String nome, String sobrenome, LocalDate dataNascimento, Sexo sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.setSexo(sexo);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
