package br.com.west.context.validationcontext;

import br.com.west.context.exception.ValidationException;

public interface Validable {

	void validate(ValidationContext context) throws ValidationException;
}
