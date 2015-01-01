package br.com.west.comum.aplicacao.usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.west.comum.aplicacao.annotation.UsuarioServiceInject;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.comum.dominio.usuario.UsuarioFiltro;
import br.com.west.comum.dominio.usuario.UsuarioRepository;
import br.com.west.comum.dominio.usuario.UsuarioService;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.AbstractSimpleFacade;

@Stateless
public class UsuarioFacadeImpl extends AbstractSimpleFacade<Usuario, UsuarioFiltro, Long, UsuarioService, UsuarioRepository> implements UsuarioFacade {

	private static final long serialVersionUID = 4019501465582849609L;

	@Inject
	@UsuarioServiceInject
	private UsuarioService usuarioService;

	@Override
	public Usuario buscarUsuarioPorNomeSenha(final String nomeUsuario, final String senha) throws WestException {
		return usuarioService.buscarUsuarioPorNomeSenha(nomeUsuario, senha);
	}

	@Override
	protected UsuarioService getService() {
		return usuarioService;
	}

}
