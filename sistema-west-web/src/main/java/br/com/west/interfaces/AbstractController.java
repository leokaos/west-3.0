package br.com.west.interfaces;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.west.interfaces.infraestrutura.GerenciadorSessao;
import br.com.west.interfaces.infraestrutura.GerenciadorSessaoAnnotation;

public abstract class AbstractController implements Serializable {

	private static final long serialVersionUID = 8974926977701930385L;

	@Inject
	@GerenciadorSessaoAnnotation
	protected GerenciadorSessao gerenciadorSessao;

	public AbstractController() {
		super();
	}

	@PostConstruct
	public void postConstruct() {
		inicializar();
	}

	public void setGerenciadorSessao(final GerenciadorSessao gerenciadorSessao) {
		this.gerenciadorSessao = gerenciadorSessao;
	}

	protected abstract void inicializar();
}
