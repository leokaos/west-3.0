package br.com.west.infraestrutura;

import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;

import com.google.common.collect.Lists;

public abstract class AbstractTest<T> {

	private static List<Object> mocks;

	static {
		mocks = Lists.newArrayList();
	}

	@Before
	public void resetAll() {
		reset(mocks.toArray());
	}

	public static void verifyAll() {
		verify(mocks.toArray());
	}

	public static void replayAll() {
		replay(mocks.toArray());
	}

	public static void addMock(final Object mock) {
		mocks.add(mock);
	}

	protected void validarException(final Exception ex, final String message, final Class<?> clazz) {
		assertEquals(ex.getMessage(), message);
		assertThat(ex, instanceOf(clazz));
	}

	protected abstract T createObjetoParaTestar();
}
