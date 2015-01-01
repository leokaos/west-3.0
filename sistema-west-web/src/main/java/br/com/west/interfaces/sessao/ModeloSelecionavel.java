package br.com.west.interfaces.sessao;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.com.west.infraestrutura.Identifiable;

public class ModeloSelecionavel<T extends Identifiable<E>, E extends Serializable> extends ListDataModel<T> implements SelectableDataModel<T> {

	private final List<T> lista;

	public ModeloSelecionavel(final List<T> lista) {
		super(lista);

		this.lista = lista;
	}

	public List<T> getLista() {
		return lista;
	}

	@Override
	public T getRowData(final String key) {
		for (final T t : lista) {
			if (t.getId().toString().equals(key)) {
				return t;
			}
		}

		return null;
	}

	@Override
	public Object getRowKey(final T t) {
		return t.getId();
	}
}
