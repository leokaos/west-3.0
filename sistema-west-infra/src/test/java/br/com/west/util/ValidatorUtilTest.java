package br.com.west.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

import br.com.west.context.exception.DominioException;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.AbstractTest;
import br.com.west.util.ValidatorUtil;

import com.google.common.collect.Lists;

public class ValidatorUtilTest extends AbstractTest<ValidatorUtil> {

	private static final String MESSAGE_ERROR = "message";

	@Override
	protected ValidatorUtil createObjetoParaTestar() {
		fail();

		return null;
	}

	@Test
	public void notFalseTest() throws Exception {
		assertTrue(ValidatorUtil.not(false));
	}

	@Test
	public void notTrueTest() throws Exception {
		assertFalse(ValidatorUtil.not(true));
	}

	@Test
	public void isNullTest() throws Exception {
		assertTrue(ValidatorUtil.isNull(null));

		assertFalse(ValidatorUtil.isNull(new Object()));
	}

	@Test
	public void isNotNullTest() throws Exception {
		assertFalse(ValidatorUtil.isNotNull(null));

		assertTrue(ValidatorUtil.isNotNull(new Object()));
	}

	@Test
	public void isEmptyStringTest() throws Exception {

		assertTrue(ValidatorUtil.isEmpty(""));

		assertTrue(ValidatorUtil.isEmpty((String) null));

		assertFalse(ValidatorUtil.isEmpty("TESTE"));
	}

	@Test
	public void isEmptyCollectionTest() throws Exception {

		final List<Object> collection = Lists.newArrayList();

		assertTrue(ValidatorUtil.isEmpty(collection));

		assertTrue(ValidatorUtil.isEmpty((Collection<?>) null));

		collection.add(new Object());

		assertFalse(ValidatorUtil.isEmpty(collection));
	}

	@Test
	public void isNotEmptyStringTest() throws Exception {

		assertFalse(ValidatorUtil.isNotEmpty(""));

		assertFalse(ValidatorUtil.isNotEmpty((String) null));

		assertTrue(ValidatorUtil.isNotEmpty("TESTE"));
	}

	@Test
	public void isNotEmptyCollectionTest() throws Exception {

		final List<Object> collection = Lists.newArrayList();

		assertFalse(ValidatorUtil.isNotEmpty(collection));

		assertFalse(ValidatorUtil.isNotEmpty((Collection<?>) null));

		collection.add(new Object());

		assertTrue(ValidatorUtil.isNotEmpty(collection));
	}

	@Test
	public void assertVazioDominioVazioTest() throws Exception {
		try {
			ValidatorUtil.assertNullDominio(null, MESSAGE_ERROR);
		} catch (final WestException e) {
			validarException(e, MESSAGE_ERROR, DominioException.class);
		}
	}

	@Test
	public void assertVazioDominioNaoVazioTest() throws Exception {
		try {
			ValidatorUtil.assertNullDominio("Teste", MESSAGE_ERROR);
		} catch (final WestException e) {
			fail();
		}
	}

	@Test
	public void assertTrueDominioTrueTest() throws Exception {
		try {
			ValidatorUtil.assertTrueDominio(true, MESSAGE_ERROR);
		} catch (final WestException e) {
			validarException(e, MESSAGE_ERROR, DominioException.class);
		}
	}

	@Test
	public void assertTrueDominioFalseTest() throws Exception {
		try {
			ValidatorUtil.assertTrueDominio(false, MESSAGE_ERROR);
		} catch (final WestException e) {
			fail();
		}
	}

	@Test
	public void assertFalseDominioTrueTest() throws Exception {
		try {
			ValidatorUtil.assertFalseDominio(false, MESSAGE_ERROR);
		} catch (final WestException e) {
			validarException(e, MESSAGE_ERROR, DominioException.class);
		}
	}

	@Test
	public void assertFalseDominioFalseTest() throws Exception {
		try {
			ValidatorUtil.assertFalseDominio(true, MESSAGE_ERROR);
		} catch (final WestException e) {
			fail();
		}
	}

}
