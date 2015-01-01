package br.com.west.comum.dominio.parametro;

import static br.com.west.comum.dominio.parametro.TipoParametro.PROPERTY_INTEGER;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = PROPERTY_INTEGER)
public class ParametroInteger extends ParametroBasico<Integer> {

	private static final long serialVersionUID = 5886567505555658769L;

	@Override
	public Integer getValorParametro() {
		return Integer.valueOf(getValor());
	}

	@Override
	public void setValorParametro(final Integer t) {
		setValor(t.toString());
	}

}
