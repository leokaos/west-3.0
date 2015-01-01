package br.com.west.interfaces.infraestrutura;

import static br.com.west.util.ValidatorUtil.isNotNull;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.west.interfaces.sessao.UsuarioLogado;

@GerenciadorSessaoAnnotation
public class GerenciadorSessaoImpl implements GerenciadorSessao {

	private static final long serialVersionUID = -8718825542398284434L;

	public GerenciadorSessaoImpl() {
		super();
	}

	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	private HttpSession getSession() {
		return getRequest().getSession();
	}

	protected void colocarObjetoSessao(final Object obj, final String name) {
		getSession().setAttribute(name, obj);
	}

	@SuppressWarnings("unchecked")
	protected <T> T resgatarObjetoSessao(final String nome) {
		return (T) getSession().getAttribute(nome);
	}

	@Override
	public UsuarioLogado getUsuarioLogado() {
		return resgatarObjetoSessao(USUARIO_LOGADO);
	}

	@Override
	public void setUsuarioLogado(final UsuarioLogado usuarioLogado) {
		colocarObjetoSessao(usuarioLogado, USUARIO_LOGADO);
	}

	@Override
	public void invalidarSessao() {

		getSession().removeAttribute(USUARIO_LOGADO);

		getSession().invalidate();
	}

	@Override
	public boolean isUsuarioLogado() {
		return isNotNull(getUsuarioLogado());
	}

}
