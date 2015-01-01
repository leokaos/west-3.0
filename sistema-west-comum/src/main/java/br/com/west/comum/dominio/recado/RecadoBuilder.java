package br.com.west.comum.dominio.recado;

import java.util.Date;

import br.com.west.comum.dominio.usuario.Usuario;
import br.com.west.comum.dominio.usuario.UsuarioBuilder;
import br.com.west.infraestrutura.Builder;

public class RecadoBuilder implements Builder<Recado> {

	private static final long serialVersionUID = 1629914568734162061L;

	private Usuario usuario;
	private String descricao;
	private Date entrada;

	private RecadoBuilder() {
		super();
	}

	public static RecadoBuilder recado() {
		return new RecadoBuilder();
	}

	public RecadoBuilder usuario(final String usuario, final Long id) {
		this.usuario = UsuarioBuilder.usuario().nome(usuario).id(id).build();

		return this;
	}

	public RecadoBuilder descricao(final String descricao) {
		this.descricao = descricao;

		return this;
	}

	public RecadoBuilder entrada(final Date entrada) {
		this.entrada = entrada;

		return this;
	}

	@Override
	public Recado build() {
		final Recado recado = new Recado();

		recado.setDescricao(descricao);
		recado.setDataEntrada(entrada);
		recado.setUsuario(usuario);

		return recado;
	}
}
