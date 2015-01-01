package br.com.west.infraestrutura;

public abstract class InfraestruturaMensagens {

	public static final String FILTRO_INVALIDO = "filtro.invalido";
	public static final String ENTIDADE_INVALIDA = "entidade.invalida";
	public static final String NAO_ENCONTRADO = "nao.encontrado";
	public static final String MAIS_DE_UM_RESULTADO = "mais.de.um.resultado";

	// PERIODO
	public static final String PERIODO_DATA_INICIAL_NULA = "periodo.data.inicial.nula";
	public static final String PERIODO_DATA_FINAL_NULA = "periodo.data.final.nula";
	public static final String PERIODO_DATA_INICIAL_MAIOR = "periodo.data.inicial.maior";

	protected InfraestruturaMensagens() {
		super();
	}

}
