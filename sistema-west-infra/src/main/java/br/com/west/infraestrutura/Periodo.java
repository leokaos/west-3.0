package br.com.west.infraestrutura;

import static br.com.west.context.constraint.ConstraintFactory.comparableLessThan;
import static br.com.west.context.constraint.ConstraintFactory.notNullValue;
import static br.com.west.infraestrutura.InfraestruturaMensagens.PERIODO_DATA_FINAL_NULA;
import static br.com.west.infraestrutura.InfraestruturaMensagens.PERIODO_DATA_INICIAL_MAIOR;
import static br.com.west.infraestrutura.InfraestruturaMensagens.PERIODO_DATA_INICIAL_NULA;
import static br.com.west.util.ValidatorUtil.isNotNull;
import static br.com.west.util.ValidatorUtil.maximoHoraMinutoSegundo;
import static br.com.west.util.ValidatorUtil.minimoHoraMinutoSegundo;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.west.context.exception.ValidationException;
import br.com.west.context.validationcontext.ValidationContext;

public class Periodo extends ValueObject<Periodo> {

	public static final String ATRIBUTO_DATA_INICIAL = "dataInicial";
	public static final String ATRIBUTO_DATA_FINAL = "dataFinal";

	private static final long serialVersionUID = -2701173320813247466L;

	private final Date dataInicial;
	private final Date dataFinal;

	public Periodo(final Date dataInicial, final Date dataFinal) {
		super();

		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void extremos() {

		if (isNotNull(dataInicial)) {
			minimoHoraMinutoSegundo(dataInicial);
		}

		if (isNotNull(dataFinal)) {
			maximoHoraMinutoSegundo(dataFinal);
		}

	}

	@Override
	protected EqualsBuilder getEqualsBuilder(final Periodo other) {
		return new EqualsBuilder().append(dataInicial, other.getDataInicial()).append(dataFinal, other.getDataFinal());
	}

	@Override
	protected HashCodeBuilder getHashCodeBuilder() {
		return new HashCodeBuilder().append(dataInicial).append(dataFinal);
	}

	@Override
	public void validate(final ValidationContext context) throws ValidationException {
		super.validate(context);

		context.add(notNullValue(dataInicial), PERIODO_DATA_INICIAL_NULA, ATRIBUTO_DATA_INICIAL);
		context.add(notNullValue(dataFinal), PERIODO_DATA_FINAL_NULA, ATRIBUTO_DATA_FINAL);

		context.add(comparableLessThan(dataInicial, dataFinal), PERIODO_DATA_INICIAL_MAIOR, ATRIBUTO_DATA_INICIAL, dataInicial, dataFinal);
	}

}
