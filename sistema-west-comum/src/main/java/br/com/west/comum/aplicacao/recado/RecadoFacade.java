package br.com.west.comum.aplicacao.recado;

import java.util.List;

import javax.ejb.Local;

import br.com.west.comum.dominio.recado.Recado;
import br.com.west.comum.dominio.recado.RecadoFiltro;
import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.SimpleFacade;

@Local
public interface RecadoFacade extends SimpleFacade<Recado, RecadoFiltro, Long> {

	List<Recado> buscarRecadosPorUsuario(final Usuario usuario) throws WestException;

}
