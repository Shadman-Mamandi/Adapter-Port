package com.example.demo.validation;

import org.springframework.validation.FieldError;

import java.util.Optional;


public interface ValidationRule<T> {

    Optional<FieldError> validate(T t, Long id);

}
