package br.com.west.util;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DataUtilsTest {

	@Test
	public void maximoSegundosTest() throws Exception {
		final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		final Date data = format.parse("2015-04-06 16:08:04");

		final Date dataFinal = DataUtils.maximo(data, Calendar.MINUTE);

		assertEquals(format.format(dataFinal), "2015-04-06 16:08:59");
	}

	@Test
	public void maximoMinutosTest() throws Exception {
		final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		final Date data = format.parse("2015-04-06 16:08:04");

		final Date dataFinal = DataUtils.maximo(data, Calendar.HOUR_OF_DAY);

		assertEquals(format.format(dataFinal), "2015-04-06 16:59:59");
	}

	@Test
	public void maximoHorasTest() throws Exception {
		final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		final Date data = format.parse("2015-04-06 16:08:04");

		final Date dataFinal = DataUtils.maximo(data, Calendar.DAY_OF_MONTH);

		assertEquals(format.format(dataFinal), "2015-04-06 23:59:59");
	}

	@Test
	public void maximoDiasTest() throws Exception {
		final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		final Date data = format.parse("2015-04-06 16:08:04");

		final Date dataFinal = DataUtils.maximo(data, Calendar.MONTH);

		assertEquals(format.format(dataFinal), "2015-04-30 23:59:59");
	}

	@Test
	public void maximoMesTest() throws Exception {
		final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		final Date data = format.parse("2015-04-06 16:08:04");

		final Date dataFinal = DataUtils.maximo(data, Calendar.YEAR);

		assertEquals(format.format(dataFinal), "2015-12-31 23:59:59");
	}

	@Test(expected = IllegalArgumentException.class)
	public void maximoFieldInvalidoTest() throws Exception {
		final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		final Date data = format.parse("2015-04-06 16:08:04");

		DataUtils.maximo(data, Calendar.DAY_OF_WEEK_IN_MONTH);
	}

}
