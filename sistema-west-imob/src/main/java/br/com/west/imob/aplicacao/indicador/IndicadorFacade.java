package br.com.west.imob.aplicacao.indicador;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.context.exception.WestException;
import br.com.west.imob.dominio.indicador.Indicador;

@Local
public interface IndicadorFacade extends Serializable {

	List<Indicador> buscarIndicadoresPorUsuario(Usuario usuario) throws WestException;

}
