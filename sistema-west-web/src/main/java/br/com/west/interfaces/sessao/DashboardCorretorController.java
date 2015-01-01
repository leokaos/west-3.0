package br.com.west.interfaces.sessao;

import static br.com.west.imob.dominio.indicador.TipoIndicador.CLIENTE;
import static br.com.west.imob.dominio.indicador.TipoIndicador.IMOVEL;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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

			modelo.setIndicadores(indicadorFacade.buscarIndicadoresPorUsuario(gerenciadorSessao.getUsuarioLogado().getUsuario()));

		} catch (final WestException e) {

		}
	}

	public boolean isImovel(final Indicador indicador) {
		return IMOVEL.equals(indicador.getTipo());
	}

	public boolean isCliente(final Indicador indicador) {
		return CLIENTE.equals(indicador.getTipo());
	}
}
