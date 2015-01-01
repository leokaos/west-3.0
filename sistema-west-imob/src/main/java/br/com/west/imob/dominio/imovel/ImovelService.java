package br.com.west.imob.dominio.imovel;

import javax.inject.Inject;

import br.com.west.comum.aplicacao.annotation.ImovelServiceInject;
import br.com.west.infraestrutura.AbstractService;

@ImovelServiceInject
public class ImovelService extends AbstractService<Imovel, ImovelFiltro, Long, ImovelRepository> {

	private static final long serialVersionUID = -9059744786640434673L;

	@Inject
	public ImovelService(final ImovelRepository repositorio) {
		super(repositorio);
	}

}