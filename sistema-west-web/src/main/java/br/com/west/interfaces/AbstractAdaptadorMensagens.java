package br.com.west.interfaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.west.context.constraint.Error;
import br.com.west.context.exception.ValidationException;

public final class AbstractAdaptadorMensagens {

	public static void adicionarMensagemErro(final String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null));
	}

	public static void adicionarMensagemErro(final String componente, final String mensagem) {
		FacesContext.getCurrentInstance().addMessage(componente, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null));
	}

	public static void adicionarMensagemInfo(final String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null));
	}

	public static void adicionarMensagemInfo(final String componente, final String mensagem) {
		FacesContext.getCurrentInstance().addMessage(componente, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null));
	}

	public static void adicionarMensagemErro(final ValidationException ex) {
		for (final Error erro : ex.getErrors()) {
			FacesContext.getCurrentInstance().addMessage(erro.getAttribute(), new FacesMessage(FacesMessage.SEVERITY_ERROR, erro.getMessage(), null));
		}
	}
}
