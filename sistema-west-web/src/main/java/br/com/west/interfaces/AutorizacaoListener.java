package br.com.west.interfaces;

import static br.com.west.interfaces.infraestrutura.GerenciadorSessao.USUARIO_LOGADO;
import static br.com.west.util.ValidatorUtil.isNotNull;
import static br.com.west.util.ValidatorUtil.not;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;

public class AutorizacaoListener implements PhaseListener {

	private static final long serialVersionUID = -3268664676879687451L;

	private static final String PAGINA_LOGIN = "index.xhtml";

	@Override
	public void afterPhase(final PhaseEvent event) {

		final FacesContext facesContext = event.getFacesContext();

		final String currentPage = facesContext.getViewRoot().getViewId();

		final boolean loginPage = (currentPage.lastIndexOf(PAGINA_LOGIN) > -1);

		if (not(loginPage) && not(isUsuarioLogado())) {

			facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "login");

			AbstractAdaptadorMensagens.adicionarMensagemErro("Usuário não logado!");
		}

	}

	private boolean isUsuarioLogado() {
		final HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

		return isNotNull(request.getSession().getAttribute(USUARIO_LOGADO));
	}

	@Override
	public void beforePhase(final PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
}
