package br.com.west.interfaces.sessao;

import java.io.Serializable;
import java.util.List;

import br.com.west.imob.dominio.indicador.Indicador;

public class DashboardCorretorModel implements Serializable {

	private static final long serialVersionUID = 5118328177084503658L;

	private List<Indicador> indicadores;

	public DashboardCorretorModel() {
		super();
	}

	public List<Indicador> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(final List<Indicador> indicadores) {
		this.indicadores = indicadores;
	}

}
