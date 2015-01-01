package br.com.west.interfaces;

import java.util.List;

import br.com.west.comum.dominio.parametro.ParametroBasico;

public class ParametroModel extends AbstractModel {

	private static final long serialVersionUID = -3579785675489690093L;

	private List<ParametroBasico<Object>> parametros;

	public ParametroModel() {
		super();
	}

	public List<ParametroBasico<Object>> getParametros() {
		return parametros;
	}

	public void setParametros(final List<ParametroBasico<Object>> parametros) {
		this.parametros = parametros;
	}

}
