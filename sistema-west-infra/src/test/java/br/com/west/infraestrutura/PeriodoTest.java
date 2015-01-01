package br.com.west.infraestrutura;

import static br.com.west.infraestrutura.InfraestruturaMensagens.PERIODO_DATA_FINAL_NULA;
import static br.com.west.infraestrutura.InfraestruturaMensagens.PERIODO_DATA_INICIAL_MAIOR;
import static br.com.west.infraestrutura.InfraestruturaMensagens.PERIODO_DATA_INICIAL_NULA;
import static br.com.west.infraestrutura.Periodo.ATRIBUTO_DATA_FINAL;
import static br.com.west.infraestrutura.Periodo.ATRIBUTO_DATA_INICIAL;
import static br.com.west.util.ValidatorUtil.assertValidable;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import br.com.west.context.constraint.Error;
import br.com.west.context.exception.ValidationException;
import br.com.west.context.exception.WestException;

public class PeriodoTest extends AbstractTest<Periodo> {

	@Override
	protected Periodo createObjetoParaTestar() {
		return new Periodo(new Date(), DateUtils.addDays(new Date(), 1));
	}

	@Test
	public void validateCorretoTest() {

		final Periodo periodo = createObjetoParaTestar();

		try {
			assertValidable(periodo);
		} catch (final WestException e) {
			fail();
		}
	}

	@Test
	public void validateAmbasDatasNulasTest() {

		final Periodo periodo = new Periodo(null, null);

		try {
			assertValidable(periodo);
			fail();
		} catch (final ValidationException ex) {

			assertTrue(ex.getErrors().contains(new Error(ATRIBUTO_DATA_INICIAL, PERIODO_DATA_INICIAL_NULA)));
			assertTrue(ex.getErrors().contains(new Error(ATRIBUTO_DATA_FINAL, PERIODO_DATA_FINAL_NULA)));
			assertTrue(ex.getErrors().contains(new Error(ATRIBUTO_DATA_INICIAL, PERIODO_DATA_INICIAL_MAIOR, null, null)));

		} catch (final WestException e) {
			fail();
		}
	}

}
