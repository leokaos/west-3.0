package br.com.west.interfaces.sessao;

import static br.com.west.imob.dominio.indicador.TipoIndicador.CLIENTE;
import static br.com.west.imob.dominio.indicador.TipoIndicador.IMOVEL;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.WestException;
import br.com.west.imob.aplicacao.indicador.IndicadorFacade;
import br.com.west.imob.dominio.indicador.Indicador;
import br.com.west.interfaces.AbstractController;

@ViewScoped
@ManagedBean
public class DashboardCorretorController extends AbstractController {

	private static final long serialVersionUID = -7122647058473782238L;

	@EJB
	private IndicadorFacade indicadorFacade;

	private final DashboardCorretorModel modelo;

	public DashboardCorretorController() {
		super();

		this.modelo = new DashboardCorretorModel();
	}

	public DashboardCorretorModel getModelo() {
		return modelo;
	}

	@Override
	protected void inicializar() {

		try {

			final Usuario usuario = gerenciadorSessao.getUsuarioLogado().getUsuario();

			modelo.setIndicadores(indicadorFacade.buscarIndicadoresPorUsuario(usuario));

			modelo.setIndicadoresHistoricosClientes(indicadorFacade.buscarHistoricoIndicadoresPorUsuarioDeClientes(usuario));
			modelo.setIndicadoresHistoricosImovel(indicadorFacade.buscarHistoricoIndicadoresPorUsuarioDeImovel(usuario));

			construirGraficos();

		} catch (final WestException e) {

		}
	}

	private void construirGraficos() {

		modelo.setClienteChartModel(createChartModel("578EBE", "Clientes", modelo.getIndicadoresHistoricosClientes()));

		modelo.setImovelChartModel(createChartModel("E35B5A", "Imóvel", modelo.getIndicadoresHistoricosImovel()));
	}

	private LineChartModel createChartModel(final String seriesColor, final String labelSerie, final List<Indicador> indicadores) {

		final LineChartModel model = new LineChartModel();
		model.setSeriesColors(seriesColor);

		final ChartSeries serie = new ChartSeries(labelSerie);

		for (final Indicador indicador : indicadores) {
			serie.set(indicador.getDescricao(), indicador.getValue());
		}

		model.addSeries(serie);

		final Axis yAxis = model.getAxis(AxisType.Y);
		yAxis.setLabel(labelSerie);

		model.setShowPointLabels(true);
		model.getAxes().put(AxisType.X, new CategoryAxis());

		return model;
	}

	public boolean isImovel(final Indicador indicador) {
		return IMOVEL.equals(indicador.getTipo());
	}

	public boolean isCliente(final Indicador indicador) {
		return CLIENTE.equals(indicador.getTipo());
	}
}
