package org.example.validation;


import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class EntityValidator {
    public static final ValidatorFactory validatorFactory = Validation.byDefaultProvider()
            .configure()
            .messageInterpolator(new ParameterMessageInterpolator()).buildValidatorFactory();

    public static final Validator validator = validatorFactory.usingContext()
            .messageInterpolator(new ParameterMessageInterpolator()).getValidator();
}
