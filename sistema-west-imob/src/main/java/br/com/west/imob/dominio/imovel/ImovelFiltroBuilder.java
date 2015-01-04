package br.com.west.imob.dominio.imovel;

import java.util.Date;

import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.infraestrutura.Builder;
import br.com.west.infraestrutura.Periodo;

public class ImovelFiltroBuilder implements Builder<ImovelFiltro> {

	private static final long serialVersionUID = -8718738735854460926L;

	private final ImovelFiltro filtro;

	private ImovelFiltroBuilder() {
		super();

		this.filtro = new ImovelFiltro();
	}

	@Override
	public ImovelFiltro build() {
		return filtro;
	}

	public static ImovelFiltroBuilder imovelFiltro() {
		return new ImovelFiltroBuilder();
	}

	public ImovelFiltroBuilder usuario(final Usuario usuario) {
		this.filtro.setUsuario(usuario);
		return this;
	}

	public ImovelFiltroBuilder periodo(final Date dataInicial, final Date dataFinal) {
		this.filtro.setDataAngariacao(new Periodo(dataInicial, dataFinal));
		this.filtro.getDataAngariacao().extremos();
		return this;
	}

	public ImovelFiltroBuilder foto() {
		this.filtro.setComFoto(true);
		return this;
	}

}
