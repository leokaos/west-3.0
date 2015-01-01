package br.com.west.imob.aplicacao.imovel;

import javax.ejb.Local;

import br.com.west.imob.dominio.imovel.Imovel;
import br.com.west.imob.dominio.imovel.ImovelFiltro;
import br.com.west.infraestrutura.SimpleFacade;

@Local
public interface ImovelFacade extends SimpleFacade<Imovel, ImovelFiltro, Long> {

}
