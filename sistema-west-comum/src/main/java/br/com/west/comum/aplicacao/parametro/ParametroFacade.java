package br.com.west.comum.aplicacao.parametro;

import javax.ejb.Local;

import br.com.west.comum.dominio.parametro.ParametroBasico;
import br.com.west.comum.dominio.parametro.ParametroFiltro;
import br.com.west.context.exception.WestException;
import br.com.west.infraestrutura.SimpleFacade;

@Local
public interface ParametroFacade extends SimpleFacade<ParametroBasico<Object>, ParametroFiltro, String> {

	@SuppressWarnings("rawtypes")
	ParametroBasico buscarParametroPorNome(String nome) throws WestException;

}
