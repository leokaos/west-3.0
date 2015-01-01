package br.com.west.interfaces.sessao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.west.comum.aplicacao.recado.RecadoFacade;
import br.com.west.context.exception.WestException;
import br.com.west.imob.aplicacao.imovel.ImovelFacade;
import br.com.west.interfaces.AbstractAdaptadorMensagens;
import br.com.west.interfaces.AbstractController;

@ManagedBean
@SessionScoped
public class SessaoController extends AbstractController {

	private static final long serialVersionUID = -2077177594721262388L;

	private static final String SAIR_SISTEMA = "sairSistema";

	@EJB
	private RecadoFacade recadoFacade;

	@EJB
	private ImovelFacade imovelFacade;

	private SessaoModel modelo;

	public SessaoController() {
		super();
	}

	@Override
	protected void inicializar() {
		modelo = new SessaoModel();

		modelo.setUsuarioLogado(gerenciadorSessao.getUsuarioLogado());

		modelo.setPaginaDashboard(gerenciadorSessao.getUsuarioLogado().getPerfilPrincipal().getPaginaDashboard());
	}

	public void buscarRecados() {
		try {

			modelo.setRecadoSelecionado(null);

			modelo.setRecados(recadoFacade.buscarRecadosPorUsuario(modelo.getUsuarioLogado().getUsuario()));

		} catch (final WestException e) {
			AbstractAdaptadorMensagens.adicionarMensagemErro(e.getMessage());
		}
	}

	public SessaoModel getModelo() {
		return modelo;
	}

	public void setModelo(final SessaoModel modelo) {
		this.modelo = modelo;
	}

	public String sairDoSistema() {

		gerenciadorSessao.invalidarSessao();

		return SAIR_SISTEMA;
	}

	// EJBS
	public void setRecadoFacade(final RecadoFacade recadoFacade) {
		this.recadoFacade = recadoFacade;
	}

}
