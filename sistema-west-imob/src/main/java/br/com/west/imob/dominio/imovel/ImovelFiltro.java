package br.com.west.imob.dominio.imovel;

import static br.com.startup.query.conditions.ConditionFactory.between;
import static br.com.west.util.ValidatorUtil.isNotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.startup.query.QueryBuilder;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.AbstractFiltro;
import br.com.west.infraestrutura.Periodo;

public class ImovelFiltro extends AbstractFiltro<ImovelFiltro> {

	private static final long serialVersionUID = -8718738735854460926L;

	private Usuario usuario;
	private Periodo dataAngariacao;
	private boolean comFoto;

	public ImovelFiltro() {
		super();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

	public Periodo getDataAngariacao() {
		return dataAngariacao;
	}

	public void setDataAngariacao(final Periodo dataAngariacao) {
		this.dataAngariacao = dataAngariacao;
	}

	public boolean isComFoto() {
		return comFoto;
	}

	public void setComFoto(final boolean comFoto) {
		this.comFoto = comFoto;
	}

	public boolean hasDataAngariacao() {
		return isNotNull(dataAngariacao);
	}

	@Override
	protected EqualsBuilder getEqualsBuilder(final ImovelFiltro other) {
		return new EqualsBuilder();
	}

	@Override
	protected HashCodeBuilder getHashCodeBuilder() {
		return new HashCodeBuilder();
	}

	@Override
	public void doQuery(final QueryBuilder builder) throws WestException {

		if (hasDataAngariacao()) {
			builder.where(between("dataAngariacao", dataAngariacao.getDataInicial(), dataAngariacao.getDataFinal()));
		}
	}

	@Override
	public Class<?> getEntityClass() {
		return Imovel.class;
	}

}
