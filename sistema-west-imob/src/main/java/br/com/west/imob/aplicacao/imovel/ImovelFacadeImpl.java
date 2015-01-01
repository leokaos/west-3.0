package br.com.west.imob.aplicacao.imovel;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.west.comum.aplicacao.annotation.ImovelServiceInject;
import br.com.west.imob.dominio.imovel.Imovel;
import br.com.west.imob.dominio.imovel.ImovelFiltro;
import br.com.west.imob.dominio.imovel.ImovelRepository;
import br.com.west.imob.dominio.imovel.ImovelService;
import br.com.west.infraestrutura.AbstractSimpleFacade;

@Stateless
public class ImovelFacadeImpl extends AbstractSimpleFacade<Imovel, ImovelFiltro, Long, ImovelService, ImovelRepository> implements ImovelFacade {

	private static final long serialVersionUID = -8902079424007931466L;

	@Inject
	@ImovelServiceInject
	private ImovelService service;

	@Override
	protected ImovelService getService() {
		return service;
	}

}
