package com.omar.appchat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST) // Usualmente las validaciones fallan con código 400
    @ExceptionHandler(MethodArgumentNotValidException.class) // Captura la excepción de validación
    @ResponseBody // Devuelve el cuerpo de la respuesta
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Itera sobre los errores de los campos no válidos
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            // Agrega los detalles de cada error: campo y mensaje
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return errors; // Devuelve el mapa con los errores como respuesta
    }
}
