package com.proyectoRepaso.repasandingsapa.exception;

import com.proyectoRepaso.repasandingsapa.domain.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase encargada de manejar las excepciones y encapsularla en el objeto Response
 *
 * @author estefaniCarmona@comfama.com.co
 * @version 1.0
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected Response<List<String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        log.error("GlobalExceptionHandler.handleMethodArgumentNotValid: Error inesperado.", ex);
        Response<List<String>> response = new Response<>();
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(x -> x.getField() + ": " + x.getDefaultMessage()).collect(Collectors.toList());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setStatusName(HttpStatus.BAD_REQUEST.name());
        response.setDeveloperMessage("Algunos campos no cumplen con las reglas de negocio.");
        response.setUserMessage("Paso un error inesperado!");
        response.setData(errors);
        return response;
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Response<Void>> handleCoreException(Exception ex) {
        log.error("GlobalExceptionHandler.handleCoreException: Error inesperado.", ex);
        Response<Void> response = new Response<>();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setStatusName(HttpStatus.BAD_REQUEST.name());
        response.setDeveloperMessage(ex.getMessage());
        response.setUserMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(response);
    }


}
