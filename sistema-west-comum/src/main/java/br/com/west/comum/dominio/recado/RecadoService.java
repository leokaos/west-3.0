package br.com.west.comum.dominio.recado;

import static br.com.west.comum.dominio.recado.RecadoFiltroBuilder.recado;
import static br.com.west.util.ValidatorUtil.assertNullDominio;

import java.util.List;

import javax.inject.Inject;

import br.com.west.comum.aplicacao.ComumMesssages;
import br.com.west.comum.aplicacao.annotation.RecadoServiceInject;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.AbstractService;

@RecadoServiceInject
public class RecadoService extends AbstractService<Recado, RecadoFiltro, Long, RecadoRepository> {

	private static final long serialVersionUID = 7393073086564306317L;

	@Inject
	public RecadoService(final RecadoRepository recadoRepositorio) {
		super(recadoRepositorio);
	}

	public List<Recado> buscarRecadosPorUsuario(final Usuario usuario) throws WestException {
		assertNullDominio(usuario, ComumMesssages.RECADO_USUARIO_INVALIDO);

		final RecadoFiltro filtro = recado().usuario(usuario).build();

		return repositorio.buscarPorFiltro(filtro);
	}

}