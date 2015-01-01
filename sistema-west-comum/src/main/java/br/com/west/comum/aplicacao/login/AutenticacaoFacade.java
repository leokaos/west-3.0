package br.com.west.comum.aplicacao.login;

import java.io.Serializable;

import javax.ejb.Local;

import br.com.west.comum.dominio.login.AutenticacaoVO;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.WestException;

@Local
public interface AutenticacaoFacade extends Serializable {

	Usuario logar(AutenticacaoVO autenticacaoVo) throws WestException;

}