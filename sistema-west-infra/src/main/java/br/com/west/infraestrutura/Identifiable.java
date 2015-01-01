package br.com.west.infraestrutura;

import java.io.Serializable;

public interface Identifiable<I extends Serializable> {

	I getId();

	void setId(I newId);

}
