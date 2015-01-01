package br.com.west.interfaces.infraestrutura;

import java.io.Serializable;

import br.com.west.interfaces.sessao.UsuarioLogado;

public interface GerenciadorSessao extends Serializable {

	public static final String USUARIO_LOGADO = "usuarioLogado";

	UsuarioLogado getUsuarioLogado();

	void setUsuarioLogado(UsuarioLogado usuarioLogado);

	void invalidarSessao();

	boolean isUsuarioLogado();
}
