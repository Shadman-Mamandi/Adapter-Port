package com.example.demo.service;




import com.example.demo.validation.ValidationRule;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import javax.validation.Validation;

/**
 * The interface which has two default methods to evaluate the rules errors.
 * The methods have list of conditions and a Function that apply the conditions.
 * @param <T>
 */

public interface ValidationService<T> {

    default void evaluateRuleErrors(List<ValidationRule<T>> conditions,
                                Function<ValidationRule<T>, Optional<FieldError>> function) {
        final List<FieldError> errors = new ArrayList<>();
        for(var condition: conditions){
            final var error = function.apply(condition);
            error.ifPresent(errors::add);
        }
        if (!errors.isEmpty()){
            // throw a customised exception like FieldValidationException
            throw new RuntimeException();
        }
    }

    default void evaluateRuleErrorsById(List<ValidationRule<String>> conditions,
                                    Function<ValidationRule<String>, Optional<FieldError>> function) {
        final List<FieldError> errors = new ArrayList<>();
        for (var condition : conditions) {
            final var error = function.apply(condition);
            error.ifPresent(errors::add);
        }
        if (!errors.isEmpty()) {
            // throw a customised exception like FieldValidationException
            throw new RuntimeException();
        }
    }

    default void evaluateFieldErrors(T t, Class<?> clazz){

        final var factory = Validation.buildDefaultValidatorFactory();
        final var validator = factory.getValidator();

        var constrainViolations = validator.validate(t,clazz);


        final  List<FieldError> fieldErrors = new ArrayList<>();
        for(var constrainViolation : constrainViolations){
            fieldErrors.add(
                    new FieldError(
                            constrainViolation.getConstraintDescriptor()
                                    .getAnnotation()
                                    .annotationType()
                                    .getSimpleName(),
                            constrainViolation.getPropertyPath()
                                    .toString(),
                            constrainViolation.getMessage()
                    )
            );

        }
        if (!fieldErrors.isEmpty()){
            // throw a customised exception like FieldValidationException
            throw new RuntimeException();
        }
    }





}
