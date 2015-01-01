package br.com.west.interfaces.sessao;

import java.util.List;

import br.com.west.comum.dominio.recado.Recado;
import br.com.west.interfaces.AbstractModel;

public class SessaoModel extends AbstractModel {

	private static final long serialVersionUID = 1502230040964474401L;

	private UsuarioLogado usuarioLogado;
	private List<Recado> recados;
	private Recado recadoSelecionado;
	private String paginaDashboard;

	private ModeloSelecionavel<Recado, Long> modeloRecados;

	public SessaoModel() {
		super();
	}

	public UsuarioLogado getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(final UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public List<Recado> getRecados() {
		return recados;
	}

	public void setRecados(final List<Recado> recados) {
		this.recados = recados;

		this.modeloRecados = new ModeloSelecionavel<Recado, Long>(recados);
	}

	public Recado getRecadoSelecionado() {
		return recadoSelecionado;
	}

	public void setRecadoSelecionado(final Recado recadoSelecionado) {
		this.recadoSelecionado = recadoSelecionado;
	}

	public ModeloSelecionavel<Recado, Long> getModeloRecados() {
		return modeloRecados;
	}

	public void setModeloRecados(final ModeloSelecionavel<Recado, Long> modeloRecados) {
		this.modeloRecados = modeloRecados;
	}

	public String getPaginaDashboard() {
		return paginaDashboard;
	}

	public void setPaginaDashboard(final String paginaDashboard) {
		this.paginaDashboard = paginaDashboard;
	}

}
