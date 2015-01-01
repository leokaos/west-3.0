package br.com.west.comum.aplicacao.atendimento;

import javax.ejb.Local;

import br.com.west.comum.dominio.atendimento.Atendimento;
import br.com.west.comum.dominio.atendimento.AtendimentoFiltro;
import br.com.west.infraestrutura.SimpleFacade;

@Local
public interface AtendimentoFacade extends SimpleFacade<Atendimento, AtendimentoFiltro, Long> {

}
