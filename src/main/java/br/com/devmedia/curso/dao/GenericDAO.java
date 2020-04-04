package br.com.devmedia.curso.dao;

import java.util.List;

public interface GenericDAO<T> {
	

	void salvar(T t);
	
	void editar(T t);
	
	void excluir(Long id);
	
	T getId(Long id);
	
	List<T> getTodos(); 

}
