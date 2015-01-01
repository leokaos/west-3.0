package br.com.west.infraestrutura;

import java.io.Serializable;
import java.util.List;

import br.com.west.context.exception.WestException;

public interface SimpleFacade<T extends AbstractEntity<T, I>, F extends AbstractFiltro<F>, I extends Serializable> extends Serializable {

	void salvar(T entity) throws WestException;

	void atualizar(T entity) throws WestException;

	void deletar(T entity) throws WestException;

	void deletarPorId(I id) throws WestException;

	T buscarPorId(I id) throws WestException;

	List<T> listar() throws WestException;

	List<T> buscarPorFiltro(F filtro) throws WestException;

	Long count(F filtro) throws WestException;

}
