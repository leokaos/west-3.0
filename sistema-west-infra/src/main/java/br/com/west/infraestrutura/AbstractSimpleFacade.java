package br.com.west.infraestrutura;

import java.io.Serializable;
import java.util.List;

import br.com.west.context.exception.WestException;

public abstract class AbstractSimpleFacade<T extends AbstractEntity<T, I>, F extends AbstractFiltro<F>, I extends Serializable, S extends AbstractService<T, F, I, R>, R extends AbstractRepository<T, F, I>>
		implements SimpleFacade<T, F, I> {

	private static final long serialVersionUID = -2173100774790650669L;

	@Override
	public void salvar(final T entity) throws WestException {
		getService().salvar(entity);
	}

	@Override
	public void atualizar(final T entity) throws WestException {
		getService().atualizar(entity);
	}

	@Override
	public void deletar(final T entity) throws WestException {
		getService().deletar(entity);
	}

	@Override
	public void deletarPorId(final I id) throws WestException {
		getService().deletarPorId(id);
	}

	@Override
	public T buscarPorId(final I id) throws WestException {
		return getService().buscarPorId(id);
	}

	@Override
	public List<T> listar() throws WestException {
		return getService().listar();
	}

	@Override
	public List<T> buscarPorFiltro(final F filtro) throws WestException {
		return getService().buscarPorFiltro(filtro);
	}

	@Override
	public Long count(final F filtro) throws WestException {
		return getService().count(filtro);
	}

	protected abstract S getService();

}
