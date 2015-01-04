package br.com.west.imob.dominio.indicador;

import static br.com.west.imob.mensagens.ImobMensagens.INDICADORES_USUARIO_INVALIDO;
import static br.com.west.util.ValidatorUtil.assertNullDominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

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
import br.com.west.util.DataUtils;

@IndicadorServiceInject
public class IndicadorService implements Serializable {

	private static final long serialVersionUID = 7176005904060728880L;

	private final ImovelFacade imovelFacade;
	private final AtendimentoFacade atendimentoFacade;
	private final ParametroImobRepository parametroRepositorio;
	private final IndicadorRepository indicadorRepository;

	@Inject
	public IndicadorService(final ImovelFacade imovelFacade, final AtendimentoFacade atendimentoFacade,
			final ParametroImobRepository parametroRepositorio, final IndicadorRepository indicadorRepository) {
		super();
		this.imovelFacade = imovelFacade;
		this.atendimentoFacade = atendimentoFacade;
		this.parametroRepositorio = parametroRepositorio;
		this.indicadorRepository = indicadorRepository;
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

	protected Indicador buscarIndicadorImovelPorMes(final Usuario usuario) throws WestException {

		final Date inicio = new Date();
		final Date fim = DataUtils.addMonths(inicio, 1);

		final ImovelFiltro filtro = ImovelFiltroBuilder.imovelFiltro().usuario(usuario).periodo(inicio, fim).build();

		return construirIndicador(parametroRepositorio.getNomeIndicadorImovelPorMes(), imovelFacade.count(filtro), TipoIndicador.IMOVEL);
	}

	protected Indicador buscarIndicadorImovelPorMesComFoto(final Usuario usuario) throws WestException {

		final Date inicio = new Date();
		final Date fim = DataUtils.addMonths(inicio, 1);

		final ImovelFiltro filtro = ImovelFiltroBuilder.imovelFiltro().usuario(usuario).periodo(inicio, fim).foto().build();

		return construirIndicador(parametroRepositorio.getNomeIndicadorImovelPorMesComFoto(), imovelFacade.count(filtro), TipoIndicador.IMOVEL);
	}

	protected Indicador buscarIndicadorClientePorDia(final Usuario usuario) throws WestException {
		final AtendimentoFiltro filtro = AtendimentoFiltroBuilder.filtro().dataEntrada(new Date(), new Date()).build();

		return construirIndicador(parametroRepositorio.getNomeIndicadorClientePorDia(), atendimentoFacade.count(filtro), TipoIndicador.CLIENTE);
	}

	protected Indicador buscarIndicadorClientePorMes(final Usuario usuario) throws WestException {

		final AtendimentoFiltro filtro = AtendimentoFiltroBuilder.filtro().dataEntrada(DataUtils.getMesAtual()).build();

		return construirIndicador(parametroRepositorio.getNomeIndicadorClientePorMes(), atendimentoFacade.count(filtro), TipoIndicador.CLIENTE);
	}

	private Indicador construirIndicador(final String nome, final Number value, final TipoIndicador tipo) {
		return new Indicador(nome, new BigDecimal(value.longValue()), tipo);
	}

	public List<Indicador> buscarHistoricoIndicadoresPorUsuarioDeClientes(final Usuario usuario) throws WestException {
		assertNullDominio(usuario, INDICADORES_USUARIO_INVALIDO);

		final Map<String, BigDecimal> mapaCliente = indicadorRepository.buscarUltimosTresMesesClientes(usuario);

		final List<Indicador> indicadores = new ArrayList<Indicador>();

		for (final Entry<String, BigDecimal> entry : mapaCliente.entrySet()) {
			indicadores.add(new Indicador(entry.getKey(), entry.getValue(), TipoIndicador.CLIENTE));
		}

		return indicadores;
	}

	public List<Indicador> buscarHistoricoIndicadoresPorUsuarioDeImovel(final Usuario usuario) throws WestException {
		assertNullDominio(usuario, INDICADORES_USUARIO_INVALIDO);

		final Map<String, BigDecimal> mapaImovel = indicadorRepository.buscarUltimosTresMesesImovel(usuario);

		final List<Indicador> indicadores = new ArrayList<Indicador>();

		for (final Entry<String, BigDecimal> entry : mapaImovel.entrySet()) {
			indicadores.add(new Indicador(entry.getKey(), entry.getValue(), TipoIndicador.IMOVEL));
		}

		return indicadores;
	}
}
