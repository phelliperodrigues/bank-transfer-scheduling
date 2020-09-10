package com.bank.scheduler.controller.exception;

import lombok.Getter;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Getter
public class ApiException {

    private final List<String> errors;
    public ApiException(BindingResult bindingResult) {
        this.errors = new ArrayList<>();
        bindingResult.getAllErrors().forEach(error -> this.errors.add(error.getDefaultMessage()));
    }

}
