package br.com.west.comum.aplicacao;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.west.comum.aplicacao.annotation.ImobPU;

public class ContextApplicationImob implements Serializable {

	private static final long serialVersionUID = 5489145928144733481L;

	@Produces
	@ImobPU
	@PersistenceContext(unitName = "imobPU")
	protected EntityManager entityManager;

}
