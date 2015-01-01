package br.com.west.comum.dominio.parametro;

import static br.com.west.comum.dominio.parametro.TipoParametro.PROPERTY_STRING;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = PROPERTY_STRING)
public class ParametroString extends ParametroBasico<String> {

	private static final long serialVersionUID = 2719954159111509434L;

	@Override
	public String getValorParametro() {
		return getValor();
	}

	@Override
	public void setValorParametro(final String t) {
		setValor(t);
	}

}
