package br.com.devmedia.curso.dao;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.devmedia.curso.domain.Sexo;
import br.com.devmedia.curso.domain.Usuario;

@Repository
public class UsuarioDaoImpl implements GenericDAO<Usuario> {
	
private static List<Usuario> usuarios;
	
	public UsuarioDaoImpl() {
		createUserList();
	}
	
    private List<Usuario> createUserList() {
        if (usuarios == null) {
            usuarios = new LinkedList<Usuario>();
            usuarios.add(new Usuario(System.currentTimeMillis()+1L, "Ana", "da Silva", LocalDate.of(1992, 5, 10), Sexo.FEMININO));
            usuarios.add(new Usuario(System.currentTimeMillis()+2L, "Luiz", "dos Santos", LocalDate.of(1990, 8, 11), Sexo.MASCULINO));
            usuarios.add(new Usuario(System.currentTimeMillis()+3L, "Mariana", "Mello", LocalDate.of(1988, 9, 17),Sexo.FEMININO));
            usuarios.add(new Usuario(System.currentTimeMillis()+4L, "Caren", "Pereira"));
            usuarios.add(new Usuario(System.currentTimeMillis()+5L, "Sonia", "Fagundes"));
            usuarios.add(new Usuario(System.currentTimeMillis()+6L, "Norberto", "de Souza"));  
        }
        return usuarios;
    }

	public void salvar(Usuario usuario) {
		usuario.setId(System.currentTimeMillis());
		usuarios.add(usuario);
		
	}

	public void editar(Usuario usuario) {
		usuarios.stream()
		.filter((u) -> u.getId().equals(usuario.getId()))
		.forEach((u) -> {
			u.setNome(usuario.getNome());
			u.setSobrenome(usuario.getSobrenome());
			u.setDataNascimento(usuario.getDataNascimento());
			u.setSexo(usuario.getSexo());
		});	
	}

	public void excluir(Long id) {
		usuarios.removeIf((u) -> u.getId().equals(id));		
	}

	public Usuario getId(Long id) {
		return usuarios.stream()
				.filter((u) -> u.getId().equals(id))
				.collect(Collectors.toList()).get(0);
	}

	public List<Usuario> getTodos() {
		return usuarios;
	}

}
