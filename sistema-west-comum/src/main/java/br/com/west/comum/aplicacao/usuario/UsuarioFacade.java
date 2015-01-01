package br.com.west.comum.aplicacao.usuario;

import javax.ejb.Local;

import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.comum.dominio.usuario.UsuarioFiltro;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.SimpleFacade;

@Local
public interface UsuarioFacade extends SimpleFacade<Usuario, UsuarioFiltro, Long> {

	Usuario buscarUsuarioPorNomeSenha(String nomeUsuario, String senha) throws WestException;
}
