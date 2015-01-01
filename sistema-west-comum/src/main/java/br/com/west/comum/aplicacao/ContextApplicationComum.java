package br.com.west.comum.aplicacao;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.west.comum.aplicacao.annotation.ComumPU;

public class ContextApplicationComum implements Serializable {

	private static final long serialVersionUID = 5489145928144733481L;

	@Produces
	@ComumPU
	@PersistenceContext(unitName = "comumPU")
	protected EntityManager entityManager;

}
