package br.com.west.util;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import br.com.west.context.exception.DominioException;
import br.com.west.context.exception.WestException;
import br.com.west.context.validationcontext.Validable;
import br.com.west.context.validationcontext.ValidationContext;
import br.com.west.context.validationcontext.ValidationContextImpl;

public class ValidatorUtil {

	private ValidatorUtil() {
		super();
	}

	public static boolean isNull(final Object obj) {
		return obj == null;
	}

	public static boolean isNotNull(final Object obj) {
		return not(isNull(obj));
	}

	public static boolean not(final boolean condition) {
		return !condition;
	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(final Object obj) {
		if (isNull(obj)) {
			return true;
		}

		if (obj instanceof String) {
			return isEmpty((String) obj);
		}

		if (obj instanceof Collection) {
			return isEmpty((Collection) obj);
		}

		return true;
	}

	public static boolean isNotEmpty(final Object obj) {
		return not(isEmpty(obj));
	}

	private static boolean isEmpty(final String str) {
		return str.isEmpty();
	}

	private static boolean isEmpty(final Collection<?> collection) {
		return collection.isEmpty();
	}

	public static void assertValidable(final Validable validable) throws WestException {
		final ValidationContext context = ValidationContextImpl.getInstance();

		validable.validate(context);

		context.validate();
	}

	public static void assertNullDominio(final Object obj, final String message) throws WestException {
		if (isNull(obj)) {
			throw new DominioException(message);
		}
	}

	public static void assertTrueDominio(final boolean condition, final String messageError) throws WestException {
		if (condition) {
			throw new DominioException(messageError);
		}
	}

	public static void assertFalseDominio(final boolean condition, final String messageError) throws WestException {
		if (not(condition)) {
			throw new DominioException(messageError);
		}
	}

	public static void assertVazioDominio(final String str, final String messageError) throws WestException {
		assertNullDominio(str, messageError);

		if (isEmpty(str)) {
			throw new DominioException(messageError);
		}
	}

	public static void minimoHoraMinutoSegundo(final Date data) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);

		calendar.set(Calendar.HOUR_OF_DAY, calendar.getMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getMinimum(Calendar.MILLISECOND));

		data.setTime(calendar.getTimeInMillis());
	}

	public static void maximoHoraMinutoSegundo(final Date data) {

		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);

		calendar.set(Calendar.HOUR, calendar.getMaximum(Calendar.HOUR));
		calendar.set(Calendar.MINUTE, calendar.getMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getMaximum(Calendar.MILLISECOND));

		data.setTime(calendar.getTimeInMillis());
	}

}
