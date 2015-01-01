package br.com.west.infraestrutura;

import static br.com.west.infraestrutura.InfraestruturaMensagens.MAIS_DE_UM_RESULTADO;
import static br.com.west.util.ValidatorUtil.isNull;
import static br.com.west.util.ValidatorUtil.not;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.startup.query.QueryBuilder;
import br.com.west.context.exception.InfraestruturaException;
import br.com.west.context.exception.SemResultadoException;
import br.com.west.context.exception.WestException;

public abstract class AbstractRepository<T extends AbstractEntity<T, I>, F extends AbstractFiltro<F>, I extends Serializable> implements Serializable {

	private static final long serialVersionUID = 5183472034364377825L;

	protected EntityManager entityManager;

	public AbstractRepository(final EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public void salvar(final T entity) throws WestException {
		entityManager.persist(entity);
	}

	public void atualizar(final T entity) throws WestException {
		entityManager.merge(entity);
	}

	public void deletar(final T entity) throws WestException {
		entityManager.remove(entity);
	}

	public List<T> listar() throws WestException {
		return buscarPorFiltro(getFiltroVazio());
	}

	@SuppressWarnings("unchecked")
	public T buscarPorId(final I id) throws WestException {

		final T entity = (T) entityManager.find(getFiltroVazio().getEntityClass(), id);

		if (isNull(entity)) {
			throw new SemResultadoException();
		}

		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> buscarPorFiltro(final F filtro) throws WestException {
		final QueryBuilder select = QueryBuilder.select(filtro.getEntityClass());

		filtro.doQuery(select);

		final List<T> resultList = select.build(entityManager).getResultList();

		if (not(resultList.iterator().hasNext())) {
			throw new SemResultadoException();
		}

		return resultList;
	}

	@SuppressWarnings("unchecked")
	public T buscarUnico(final F filtro) throws WestException {

		final QueryBuilder select = QueryBuilder.select(filtro.getEntityClass());

		filtro.doQuery(select);

		final List<T> resultList = select.build(entityManager).getResultList();

		if (not(resultList.iterator().hasNext())) {
			throw new SemResultadoException();
		}

		if (resultList.size() > 1) {
			throw new InfraestruturaException(MAIS_DE_UM_RESULTADO);
		}

		return resultList.iterator().next();

	}

	public Long count(final F filtro) throws WestException {
		final QueryBuilder queryCount = QueryBuilder.count(filtro.getEntityClass());

		filtro.doQuery(queryCount);

		final Number count = (Number) queryCount.build(entityManager).getSingleResult();

		return count.longValue();
	}

	protected abstract F getFiltroVazio();
}
