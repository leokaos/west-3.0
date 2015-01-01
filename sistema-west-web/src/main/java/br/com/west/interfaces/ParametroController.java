package br.com.west.interfaces;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.west.comum.aplicacao.parametro.ParametroFacade;
import br.com.west.comum.dominio.parametro.ParametroBasico;
import br.com.west.context.exception.WestException;

@ManagedBean
@ViewScoped
public class ParametroController extends AbstractController {

	private static final long serialVersionUID = 1923340593612307581L;

	@EJB
	private ParametroFacade parametroFacade;

	private ParametroModel modelo;

	public ParametroController() {
		super();
	}

	@Override
	protected void inicializar() {

		try {

			modelo = new ParametroModel();

			modelo.setParametros(parametroFacade.listar());

		} catch (final WestException e) {
			AbstractAdaptadorMensagens.adicionarMensagemErro(e.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void salvar(final ParametroBasico parametro) {
		try {

			parametroFacade.salvar(parametro);

			AbstractAdaptadorMensagens.adicionarMensagemInfo("dataGridParametros", "Parametro Salvo com sucesso!");

		} catch (final WestException e) {
			AbstractAdaptadorMensagens.adicionarMensagemErro(e.getMessage());
		}
	}

	public ParametroModel getModelo() {
		return modelo;
	}

	// EJBS
	public void setParametroFacade(final ParametroFacade parametroFacade) {
		this.parametroFacade = parametroFacade;
	}

}
