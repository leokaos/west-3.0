package br.com.west.util;

import java.math.BigInteger;
import java.security.MessageDigest;

import br.com.west.context.exception.InfraestruturaException;
import br.com.west.context.exception.WestException;

public class CriptoUtil {

	public static String hash(final String value) throws WestException {
		try {

			final MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(value.getBytes());
			final BigInteger hash = new BigInteger(1, md.digest());

			return hash.toString(16);

		} catch (final Exception ex) {
			throw new InfraestruturaException(ex.getMessage(), ex);
		}
	}
}
