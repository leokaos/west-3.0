package br.com.west.comum.dominio.parametro;

import static br.com.west.comum.dominio.parametro.TipoParametro.PROPERTY_DATE;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue(value = PROPERTY_DATE)
public class ParametroDate extends ParametroBasico<Date> {

	private static final long serialVersionUID = 1337793666581792579L;

	@Transient
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public Date getValorParametro() {
		try {

			return dateFormat.parse(getValor());

		} catch (final ParseException e) {
			return null;
		}
	}

	@Override
	public void setValorParametro(final Date t) {
		setValor(dateFormat.format(t));
	}

}
