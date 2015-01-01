package br.com.west.infraestrutura;

import java.io.Serializable;

public interface Builder<T> extends Serializable {

	T build();

}
