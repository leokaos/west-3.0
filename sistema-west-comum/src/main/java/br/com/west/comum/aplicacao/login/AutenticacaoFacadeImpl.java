package br.com.west.comum.aplicacao.login;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.west.comum.aplicacao.annotation.AutenticacaoServiceInject;
import br.com.west.comum.aplicacao.usuario.UsuarioFacade;
import br.com.west.comum.dominio.login.AutenticacaoService;
import br.com.west.comum.dominio.login.AutenticacaoVO;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.WestException;

@Stateless
public class AutenticacaoFacadeImpl implements AutenticacaoFacade {

	private static final long serialVersionUID = 4019501465582849609L;

	@EJB
	private UsuarioFacade usuarioFacade;

	@Inject
	@AutenticacaoServiceInject
	private AutenticacaoService service;

	@Override
	public Usuario logar(final AutenticacaoVO autenticacaoVo) throws WestException {
		return service.logar(autenticacaoVo);
	}

}
