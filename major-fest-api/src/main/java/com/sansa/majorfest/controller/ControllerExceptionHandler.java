package com.sansa.majorfest.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessage allExeptions(Exception ex) {
        return new ErrorMessage(ex.getMessage() + Arrays.toString(ex.getStackTrace()));
    }

    @Data
    @AllArgsConstructor
    private static class ErrorMessage {
        private String message;
    }
}
