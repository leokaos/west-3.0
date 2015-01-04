package br.com.west.imob.dominio.indicador;

import static java.util.Calendar.MONTH;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.west.comum.aplicacao.annotation.ImobPU;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.WestException;
import br.com.west.imob.dominio.parametro.ParametroImobRepository;
import br.com.west.util.DataUtils;

public class IndicadorRepository {

	private final EntityManager entityManager;
	private final ParametroImobRepository parametroRepository;

	@Inject
	public IndicadorRepository(@ImobPU final EntityManager entityManager, final ParametroImobRepository parametroRepository) {
		super();
		this.entityManager = entityManager;
		this.parametroRepository = parametroRepository;
	}

	public Map<String, BigDecimal> buscarUltimosTresMesesClientes(final Usuario usuario) throws WestException {
		final Integer meses = parametroRepository.getQuantidadeMesesIndicadorCliente();

		final StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append("SELECT MONTH(data_entrada) , YEAR(data_entrada) , COUNT(*) ");
		sqlBuilder.append("FROM tab_atendimento WHERE data_entrada BETWEEN :dataInicial AND :dataFinal ");
		sqlBuilder.append("GROUP BY MONTH(data_entrada), YEAR(data_entrada) ORDER BY YEAR(data_entrada), MONTH(data_entrada)");

		return buscarIndicadores(meses, sqlBuilder.toString());
	}

	public Map<String, BigDecimal> buscarUltimosTresMesesImovel(final Usuario usuario) throws WestException {

		final Integer meses = parametroRepository.getQuantidadeMesesIndicadorImovel();

		final StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append("SELECT MONTH(data_angariacao) , YEAR(data_angariacao) , COUNT(*) ");
		sqlBuilder.append("FROM tab_imovel WHERE data_angariacao BETWEEN :dataInicial AND :dataFinal ");
		sqlBuilder.append("GROUP BY MONTH(data_angariacao), YEAR(data_angariacao) ORDER BY YEAR(data_angariacao), MONTH(data_angariacao)");

		return buscarIndicadores(meses, sqlBuilder.toString());
	}

	@SuppressWarnings("rawtypes")
	private Map<String, BigDecimal> buscarIndicadores(final Integer meses, final String sql) {
		final Query query = entityManager.createNativeQuery(sql);

		final Date dataInicial = DataUtils.addMonths(new Date(), -meses);
		final Date dataFinal = DataUtils.maximo(new Date(), MONTH);

		query.setParameter("dataInicial", dataInicial);
		query.setParameter("dataFinal", dataFinal);

		final List resultList = query.getResultList();
		final Map<String, BigDecimal> mapaIndicadores = new LinkedHashMap<>();

		for (final Iterator iterator = resultList.iterator(); iterator.hasNext();) {
			final Object[] object = (Object[]) iterator.next();

			final Integer mes = (Integer) object[0];
			final Integer ano = (Integer) object[1];
			final BigInteger quantidade = (BigInteger) object[2];

			mapaIndicadores.put(construirMesAno(mes, ano), new BigDecimal(quantidade));
		}

		return mapaIndicadores;
	}

	private String construirMesAno(final Integer mes, final Integer ano) {
		final SimpleDateFormat format = new SimpleDateFormat("MMM/yyyy");

		final Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.YEAR, ano);
		calendar.set(Calendar.MONTH, mes);

		return format.format(calendar.getTime());
	}

}
