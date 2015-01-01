package br.com.west.interfaces.login;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.west.comum.aplicacao.login.AutenticacaoFacade;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.ValidationException;
import br.com.west.context.exception.WestException;
import br.com.west.interfaces.AbstractAdaptadorMensagens;
import br.com.west.interfaces.AbstractController;
import br.com.west.interfaces.sessao.UsuarioLogado;

@ManagedBean
@RequestScoped
public class LoginController extends AbstractController {

	private static final long serialVersionUID = 1175715426923425442L;

	protected static final String ENTRAR_SISTEMA = "entrarSistema";

	@EJB
	private AutenticacaoFacade autenticacaoFacade;

	private LoginModel modelo;

	public LoginController() {
		super();
	}

	@Override
	protected void inicializar() {
		modelo = new LoginModel();
	}

	public LoginModel getModelo() {
		return modelo;
	}

	public void limpar() {
		modelo.limpar();
	}

	public String logar() {
		try {

			final Usuario usuario = autenticacaoFacade.logar(modelo.getAutenticacaoVO());

			gerenciadorSessao.setUsuarioLogado(new UsuarioLogado(usuario));

			return ENTRAR_SISTEMA;

		} catch (final ValidationException e) {
			AbstractAdaptadorMensagens.adicionarMensagemErro(e);
		} catch (final WestException e) {
			AbstractAdaptadorMensagens.adicionarMensagemErro(e.getMessage());
		}

		return null;
	}

	// EJB
	public void setAutenticacaoFacade(final AutenticacaoFacade autenticacaoFacade) {
		this.autenticacaoFacade = autenticacaoFacade;
	}

}
