package br.com.west.imob.dominio.indicador;

import static br.com.west.imob.dominio.indicador.TipoIndicador.CLIENTE;
import static br.com.west.imob.dominio.indicador.TipoIndicador.IMOVEL;
import static br.com.west.imob.mensagens.ImobMensagens.INDICADORES_USUARIO_INVALIDO;
import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.easymock.Capture;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.west.comum.aplicacao.atendimento.AtendimentoFacade;
import br.com.west.comum.dominio.atendimento.AtendimentoFiltro;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.DominioException;
import br.com.west.context.exception.WestException;
import br.com.west.imob.aplicacao.imovel.ImovelFacade;
import br.com.west.imob.dominio.imovel.ImovelFiltro;
import br.com.west.imob.dominio.parametro.ParametroImobRepository;
import br.com.west.infraestrutura.AbstractTest;

public class IndicadorServiceTest extends AbstractTest<IndicadorService> {

	private static ImovelFacade mockImovelFacade;
	private static AtendimentoFacade mockAtendimentoFacade;
	private static ParametroImobRepository mockParametroImobRepository;

	private final SimpleDateFormat formatAnoMesDia = new SimpleDateFormat("yyyy-MM-dd");
	private final SimpleDateFormat formatComleto = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

	@BeforeClass
	public static void setUp() {
		mockImovelFacade = createStrictMock(ImovelFacade.class);
		mockAtendimentoFacade = createStrictMock(AtendimentoFacade.class);
		mockParametroImobRepository = createStrictMock(ParametroImobRepository.class);

		addMock(mockImovelFacade);
		addMock(mockAtendimentoFacade);
		addMock(mockParametroImobRepository);
	}

	@Test
	public void buscarIndicadoresPorUsuarioUsuarioNuloTest() {
		final IndicadorService service = createObjetoParaTestar();

		try {
			service.buscarIndicadoresPorUsuario(null);
			fail();
		} catch (final WestException ex) {
			validarException(ex, INDICADORES_USUARIO_INVALIDO, DominioException.class);
		}

	}

	@Test
	public void buscarIndicadorClientePorMesCorretoTest() throws Exception {

		final IndicadorService service = createObjetoParaTestar();

		// Datas
		String anoMesDia = formatAnoMesDia.format(new Date());
		final String inicio = anoMesDia.concat(" 00:00:00 000");

		anoMesDia = formatAnoMesDia.format(DateUtils.addMonths(new Date(), 1));
		final String fim = anoMesDia.concat(" 23:59:59 999");

		final Capture<AtendimentoFiltro> capture = new Capture<>();

		final Usuario usuario = new Usuario();
		usuario.setId(10l);

		expect(mockParametroImobRepository.getNomeIndicadorClientePorMes()).andReturn("Clientes Por Mes");
		expect(mockAtendimentoFacade.count(capture(capture))).andReturn(10l);

		replayAll();

		final Indicador indicador = service.buscarIndicadorClientePorMes(usuario);

		verifyAll();

		final AtendimentoFiltro filtro = capture.getValue();

		assertEquals(new Indicador("Clientes Por Mes", new BigDecimal(10l), CLIENTE), indicador);

		assertEquals(filtro.getDataEntrada().getDataInicial(), formatComleto.parse(inicio));
		assertEquals(filtro.getDataEntrada().getDataFinal(), formatComleto.parse(fim));
	}

	@Test
	public void buscarIndicadorClientePorDiaCorretoTest() throws Exception {

		final IndicadorService service = createObjetoParaTestar();

		// Datas
		final String anoMesDia = formatAnoMesDia.format(new Date());
		final String inicio = anoMesDia.concat(" 00:00:00 000");
		final String fim = anoMesDia.concat(" 23:59:59 999");

		final Capture<AtendimentoFiltro> capture = new Capture<>();

		final Usuario usuario = new Usuario();
		usuario.setId(10l);

		expect(mockParametroImobRepository.getNomeIndicadorClientePorDia()).andReturn("Clientes Por Dia");
		expect(mockAtendimentoFacade.count(capture(capture))).andReturn(10l);

		replayAll();

		final Indicador indicador = service.buscarIndicadorClientePorDia(usuario);

		verifyAll();

		final AtendimentoFiltro filtro = capture.getValue();

		assertEquals(new Indicador("Clientes Por Dia", new BigDecimal(10l), CLIENTE), indicador);

		assertEquals(filtro.getDataEntrada().getDataInicial(), formatComleto.parse(inicio));
		assertEquals(filtro.getDataEntrada().getDataFinal(), formatComleto.parse(fim));
	}

	@Test
	public void buscarIndicadorImovelPorMesComFotoCorretoTest() throws Exception {

		final IndicadorService service = createObjetoParaTestar();

		// Datas
		String anoMesDia = formatAnoMesDia.format(new Date());
		final String inicio = anoMesDia.concat(" 00:00:00 000");

		anoMesDia = formatAnoMesDia.format(DateUtils.addMonths(new Date(), 1));
		final String fim = anoMesDia.concat(" 23:59:59 999");

		final Capture<ImovelFiltro> capture = new Capture<>();

		final Usuario usuario = new Usuario();
		usuario.setId(10l);

		expect(mockParametroImobRepository.getNomeIndicadorImovelPorMesComFoto()).andReturn("Imoveis com Fotos");
		expect(mockImovelFacade.count(capture(capture))).andReturn(10l);

		replayAll();

		final Indicador indicador = service.buscarIndicadorImovelPorMesComFoto(usuario);

		verifyAll();

		final ImovelFiltro filtro = capture.getValue();

		assertEquals(new Indicador("Imoveis com Fotos", new BigDecimal(10l), IMOVEL), indicador);

		assertEquals(filtro.getPeriodo().getDataInicial(), formatComleto.parse(inicio));
		assertEquals(filtro.getPeriodo().getDataFinal(), formatComleto.parse(fim));
		assertTrue(filtro.isComFoto());
	}

	@Test
	public void buscarIndicadorImovelPorMesCorretoTest() throws Exception {

		final IndicadorService service = createObjetoParaTestar();

		// Datas
		String anoMesDia = formatAnoMesDia.format(new Date());
		final String inicio = anoMesDia.concat(" 00:00:00 000");

		anoMesDia = formatAnoMesDia.format(DateUtils.addMonths(new Date(), 1));
		final String fim = anoMesDia.concat(" 23:59:59 999");

		final Capture<ImovelFiltro> capture = new Capture<>();

		final Usuario usuario = new Usuario();
		usuario.setId(10l);

		expect(mockParametroImobRepository.getNomeIndicadorImovelPorMes()).andReturn("Imoveis");
		expect(mockImovelFacade.count(capture(capture))).andReturn(10l);

		replayAll();

		final Indicador indicador = service.buscarIndicadorImovelPorMes(usuario);

		verifyAll();

		final ImovelFiltro filtro = capture.getValue();

		assertEquals(new Indicador("Imoveis", new BigDecimal(10l), IMOVEL), indicador);

		assertEquals(filtro.getPeriodo().getDataInicial(), formatComleto.parse(inicio));
		assertEquals(filtro.getPeriodo().getDataFinal(), formatComleto.parse(fim));
		assertFalse(filtro.isComFoto());
	}

	@Override
	protected IndicadorService createObjetoParaTestar() {
		return new IndicadorService(mockImovelFacade, mockAtendimentoFacade, mockParametroImobRepository);
	}

}
