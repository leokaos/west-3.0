package br.com.west.imob.dominio.indicador;

import static br.com.west.imob.mensagens.ImobMensagens.INDICADORES_USUARIO_INVALIDO;
import static br.com.west.util.ValidatorUtil.assertNullDominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.apache.commons.lang3.time.DateUtils;

import br.com.west.comum.aplicacao.annotation.IndicadorServiceInject;
import br.com.west.comum.aplicacao.atendimento.AtendimentoFacade;
import br.com.west.comum.dominio.atendimento.AtendimentoFiltro;
import br.com.west.comum.dominio.atendimento.AtendimentoFiltroBuilder;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.WestException;
import br.com.west.imob.aplicacao.imovel.ImovelFacade;
import br.com.west.imob.dominio.imovel.ImovelFiltro;
import br.com.west.imob.dominio.imovel.ImovelFiltroBuilder;
import br.com.west.imob.dominio.parametro.ParametroImobRepository;

@IndicadorServiceInject
public class IndicadorService implements Serializable {

	private static final long serialVersionUID = 7176005904060728880L;

	@EJB
	private final ImovelFacade imovelFacade;

	@EJB
	private final AtendimentoFacade atendimentoFacade;

	private final ParametroImobRepository parametroRepositorio;

	@Inject
	public IndicadorService(final ImovelFacade imovelFacade, final AtendimentoFacade atendimentoFacade, final ParametroImobRepository parametroRepositorio) {
		super();
		this.imovelFacade = imovelFacade;
		this.atendimentoFacade = atendimentoFacade;
		this.parametroRepositorio = parametroRepositorio;
	}

	public List<Indicador> buscarIndicadoresPorUsuario(final Usuario usuario) throws WestException {
		assertNullDominio(usuario, INDICADORES_USUARIO_INVALIDO);

		final List<Indicador> indicadores = new ArrayList<>();

		// Indicador imoveis

		indicadores.add(buscarIndicadorImovelPorMes(usuario));
		indicadores.add(buscarIndicadorImovelPorMesComFoto(usuario));

		// Indicador Atendimentos

		indicadores.add(buscarIndicadorClientePorDia(usuario));
		indicadores.add(buscarIndicadorClientePorMes(usuario));

		return indicadores;
	}

	protected Indicador buscarIndicadorClientePorMes(final Usuario usuario) throws WestException {

		final Date inicio = new Date();
		final Date fim = DateUtils.addMonths(inicio, 1);

		final AtendimentoFiltro filtro = AtendimentoFiltroBuilder.filtro().dataEntrada(inicio, fim).build();

		return construirIndicador(parametroRepositorio.getNomeIndicadorClientePorMes(), atendimentoFacade.count(filtro), TipoIndicador.CLIENTE);
	}

	protected Indicador buscarIndicadorClientePorDia(final Usuario usuario) throws WestException {
		final AtendimentoFiltro filtro = AtendimentoFiltroBuilder.filtro().dataEntrada(new Date(), new Date()).build();

		return construirIndicador(parametroRepositorio.getNomeIndicadorClientePorDia(), atendimentoFacade.count(filtro), TipoIndicador.CLIENTE);
	}

	protected Indicador buscarIndicadorImovelPorMesComFoto(final Usuario usuario) throws WestException {

		final Date inicio = new Date();
		final Date fim = DateUtils.addMonths(inicio, 1);

		final ImovelFiltro filtro = ImovelFiltroBuilder.imovelFiltro().usuario(usuario).periodo(inicio, fim).foto().build();

		return construirIndicador(parametroRepositorio.getNomeIndicadorImovelPorMesComFoto(), imovelFacade.count(filtro), TipoIndicador.IMOVEL);
	}

	protected Indicador buscarIndicadorImovelPorMes(final Usuario usuario) throws WestException {

		final Date inicio = new Date();
		final Date fim = DateUtils.addMonths(inicio, 1);

		final ImovelFiltro filtro = ImovelFiltroBuilder.imovelFiltro().usuario(usuario).periodo(inicio, fim).build();

		return construirIndicador(parametroRepositorio.getNomeIndicadorImovelPorMes(), imovelFacade.count(filtro), TipoIndicador.IMOVEL);
	}

	private Indicador construirIndicador(final String nome, final Number value, final TipoIndicador tipo) {
		return new Indicador(nome, new BigDecimal(value.longValue()), tipo);
	}
}
