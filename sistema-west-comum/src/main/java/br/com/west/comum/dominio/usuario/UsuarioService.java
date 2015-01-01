package br.com.west.comum.dominio.usuario;

import static br.com.west.comum.aplicacao.ComumMesssages.USUARIO_INVALIDO;
import static br.com.west.comum.dominio.usuario.UsuarioFiltroBuilder.usuarioFiltro;
import static br.com.west.util.ValidatorUtil.assertVazioDominio;

import javax.inject.Inject;

import br.com.west.comum.aplicacao.annotation.UsuarioServiceInject;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.AbstractService;

@UsuarioServiceInject
public class UsuarioService extends AbstractService<Usuario, UsuarioFiltro, Long, UsuarioRepository> {

	private static final long serialVersionUID = -1813224418737658841L;

	@Inject
	public UsuarioService(final UsuarioRepository usuarioRepository) {
		super(usuarioRepository);
	}

	public Usuario buscarUsuarioPorNomeSenha(final String nomeUsuario, final String senha) throws WestException {
		assertVazioDominio(nomeUsuario, USUARIO_INVALIDO);

		final UsuarioFiltro filtro = usuarioFiltro().nomeUsuario(nomeUsuario).senha(senha).build();

		return repositorio.buscarUnico(filtro);
	}

}
