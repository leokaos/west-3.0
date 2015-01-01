package br.com.west.imob.dominio.parametro;

import javax.ejb.EJB;
import javax.inject.Inject;

import br.com.west.comum.aplicacao.parametro.ParametroFacade;
import br.com.west.comum.dominio.parametro.ParametroString;
import br.com.west.context.exception.WestException;

public class ParametroImobRepository {

	private static final String NOME_INDICADOR_IMOVEL_POR_MES = "nomeIndicadorImovelPorMes";
	private static final String NOME_INDICADOR_IMOVEL_POR_MES_COM_FOTO = "nomeIndicadorImovelPorMesComFoto";
	private static final String NOME_INDICADOR_CLIENTE_POR_DIA = "nomeIndicadorClientePorDia";
	private static final String NOME_INDICADOR_CLIENTE_POR_MES = "nomeIndicadorClientePorMes";

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

}
