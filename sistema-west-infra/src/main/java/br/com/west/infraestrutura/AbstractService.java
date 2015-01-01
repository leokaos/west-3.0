package br.com.west.infraestrutura;

import static br.com.west.infraestrutura.InfraestruturaMensagens.ENTIDADE_INVALIDA;
import static br.com.west.infraestrutura.InfraestruturaMensagens.FILTRO_INVALIDO;
import static br.com.west.util.ValidatorUtil.assertNullDominio;
import static br.com.west.util.ValidatorUtil.assertValidable;

import java.io.Serializable;
import java.util.List;

import br.com.west.context.exception.WestException;

public abstract class AbstractService<T extends AbstractEntity<T, I>, F extends AbstractFiltro<F>, I extends Serializable, R extends AbstractRepository<T, F, I>>
		implements SimpleFacade<T, F, I> {

	private static final long serialVersionUID = 5016264088130202646L;

	protected final R repositorio;

	public AbstractService(final R repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void salvar(final T entity) throws WestException {
		assertNullDominio(entity, ENTIDADE_INVALIDA);

		repositorio.salvar(entity);
	}

	@Override
	public void atualizar(final T entity) throws WestException {
		assertNullDominio(entity, ENTIDADE_INVALIDA);

		repositorio.atualizar(entity);
	}

	@Override
	public void deletar(final T entity) throws WestException {
		assertNullDominio(entity, ENTIDADE_INVALIDA);

		repositorio.deletar(entity);
	}

	@Override
	public void deletarPorId(final I id) throws WestException {
		assertNullDominio(id, ENTIDADE_INVALIDA);

		repositorio.deletar(buscarPorId(id));
	};

	@Override
	public T buscarPorId(final I id) throws WestException {
		assertNullDominio(id, ENTIDADE_INVALIDA);

		return repositorio.buscarPorId(id);
	}

	@Override
	public List<T> listar() throws WestException {
		return repositorio.listar();
	}

	@Override
	public List<T> buscarPorFiltro(final F filtro) throws WestException {
		assertNullDominio(filtro, FILTRO_INVALIDO);
		assertValidable(filtro);

		return repositorio.buscarPorFiltro(filtro);
	}

	@Override
	public Long count(final F filtro) throws WestException {
		assertNullDominio(filtro, FILTRO_INVALIDO);
		assertValidable(filtro);

		return repositorio.count(filtro);
	}

}
