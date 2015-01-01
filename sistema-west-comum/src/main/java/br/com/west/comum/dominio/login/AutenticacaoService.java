package br.com.west.comum.dominio.login;

import static br.com.west.comum.aplicacao.ComumMesssages.USUARIO_BLOQUEADO;
import static br.com.west.comum.aplicacao.ComumMesssages.USUARIO_INEXISTENTE;
import static br.com.west.comum.aplicacao.ComumMesssages.USUARIO_SEM_PERFIL;
import static br.com.west.util.ValidatorUtil.assertFalseDominio;
import static br.com.west.util.ValidatorUtil.assertTrueDominio;
import static br.com.west.util.ValidatorUtil.assertValidable;
import static br.com.west.util.ValidatorUtil.isNotEmpty;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.inject.Inject;

import br.com.west.comum.aplicacao.annotation.AutenticacaoServiceInject;
import br.com.west.comum.aplicacao.usuario.UsuarioFacade;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.DominioException;
import br.com.west.context.exception.SemResultadoException;
import br.com.west.context.exception.WestException;
import br.com.west.util.CriptoUtil;

@AutenticacaoServiceInject
public class AutenticacaoService implements Serializable {

	private static final long serialVersionUID = -390208729938950125L;

	@EJB
	private final UsuarioFacade usuarioFacade;

	@Inject
	public AutenticacaoService(final UsuarioFacade usuarioFacade) {
		super();
		this.usuarioFacade = usuarioFacade;
	}

	public Usuario logar(final AutenticacaoVO autenticacaoVO) throws WestException {

		assertValidable(autenticacaoVO);

		try {

			final Usuario usuario = usuarioFacade.buscarUsuarioPorNomeSenha(autenticacaoVO.getUsuario(), CriptoUtil.hash(autenticacaoVO.getSenha()));

			assertTrueDominio(usuario.isBloqueado(), USUARIO_BLOQUEADO);

			assertFalseDominio(isNotEmpty(usuario.getPerfis()), USUARIO_SEM_PERFIL);

			return usuario;

		} catch (final SemResultadoException e) {
			throw new DominioException(USUARIO_INEXISTENTE);
		}
	}
}
