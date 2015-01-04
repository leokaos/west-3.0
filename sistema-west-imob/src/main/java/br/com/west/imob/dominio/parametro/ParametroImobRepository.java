package br.com.west.imob.dominio.parametro;

import javax.ejb.EJB;
import javax.inject.Inject;

import br.com.west.comum.aplicacao.parametro.ParametroFacade;
import br.com.west.comum.dominio.parametro.ParametroInteger;
import br.com.west.comum.dominio.parametro.ParametroString;
import br.com.west.context.exception.WestException;

public class ParametroImobRepository {

	private static final String NOME_INDICADOR_IMOVEL_POR_MES = "nomeIndicadorImovelPorMes";
	private static final String NOME_INDICADOR_IMOVEL_POR_MES_COM_FOTO = "nomeIndicadorImovelPorMesComFoto";
	private static final String NOME_INDICADOR_CLIENTE_POR_DIA = "nomeIndicadorClientePorDia";
	private static final String NOME_INDICADOR_CLIENTE_POR_MES = "nomeIndicadorClientePorMes";
	private static final String QUANTIDADE_MESES_INDICADOR_CLIENTE = "quantidadeMesesIndicadorCliente";
	private static final String QUANTIDADE_MESES_INDICADOR_IMOVEL = "quantidadeMesesIndicadorImovel";

	@EJB
	private final ParametroFacade parametroFacade;

	@Inject
	public ParametroImobRepository(final ParametroFacade parametroFacade) {
		super();
		this.parametroFacade = parametroFacade;
	}

	public String getNomeIndicadorImovelPorMes() throws WestException {
		final ParametroString param = (ParametroString) parametroFacade.buscarParametroPorNome(NOME_INDICADOR_IMOVEL_POR_MES);

		return param.getValor();
	}

	public String getNomeIndicadorImovelPorMesComFoto() throws WestException {
		final ParametroString param = (ParametroString) parametroFacade.buscarParametroPorNome(NOME_INDICADOR_IMOVEL_POR_MES_COM_FOTO);

		return param.getValor();
	}

	public String getNomeIndicadorClientePorDia() throws WestException {
		final ParametroString param = (ParametroString) parametroFacade.buscarParametroPorNome(NOME_INDICADOR_CLIENTE_POR_DIA);

		return param.getValor();
	}

	public String getNomeIndicadorClientePorMes() throws WestException {
		final ParametroString param = (ParametroString) parametroFacade.buscarParametroPorNome(NOME_INDICADOR_CLIENTE_POR_MES);

		return param.getValor();
	}

	public Integer getQuantidadeMesesIndicadorCliente() throws WestException {
		final ParametroInteger param = (ParametroInteger) parametroFacade.buscarParametroPorNome(QUANTIDADE_MESES_INDICADOR_CLIENTE);

		return param.getValorParametro();
	}

	public Integer getQuantidadeMesesIndicadorImovel() throws WestException {
		final ParametroInteger param = (ParametroInteger) parametroFacade.buscarParametroPorNome(QUANTIDADE_MESES_INDICADOR_IMOVEL);

		return param.getValorParametro();
	}

}
