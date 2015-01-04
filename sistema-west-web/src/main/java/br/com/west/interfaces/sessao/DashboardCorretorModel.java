package br.com.west.interfaces.sessao;

import java.io.Serializable;
import java.util.List;

import org.primefaces.model.chart.LineChartModel;

import br.com.west.imob.dominio.indicador.Indicador;

public class DashboardCorretorModel implements Serializable {

	private static final long serialVersionUID = 5118328177084503658L;

	private List<Indicador> indicadores;

	private List<Indicador> indicadoresHistoricosClientes;
	private List<Indicador> indicadoresHistoricosImovel;

	private LineChartModel clienteChartModel;
	private LineChartModel imovelChartModel;

	public DashboardCorretorModel() {
		super();
	}

	public List<Indicador> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(final List<Indicador> indicadores) {
		this.indicadores = indicadores;
	}

	public List<Indicador> getIndicadoresHistoricosClientes() {
		return indicadoresHistoricosClientes;
	}

	public void setIndicadoresHistoricosClientes(final List<Indicador> indicadoresHistoricosClientes) {
		this.indicadoresHistoricosClientes = indicadoresHistoricosClientes;
	}

	public List<Indicador> getIndicadoresHistoricosImovel() {
		return indicadoresHistoricosImovel;
	}

	public void setIndicadoresHistoricosImovel(final List<Indicador> indicadoresHistoricosImovel) {
		this.indicadoresHistoricosImovel = indicadoresHistoricosImovel;
	}

	public LineChartModel getClienteChartModel() {
		return clienteChartModel;
	}

	public void setClienteChartModel(final LineChartModel clienteChartModel) {
		this.clienteChartModel = clienteChartModel;
	}

	public LineChartModel getImovelChartModel() {
		return imovelChartModel;
	}

	public void setImovelChartModel(final LineChartModel imovelChartModel) {
		this.imovelChartModel = imovelChartModel;
	}

}
