package com.omar.appchat.exception;

import com.omar.appchat.exception.ErrorResponse;
import jakarta.servlet.http.HttpServletResponse;
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

    //Manejo de errores de validacion
        //@ResponseStatus(HttpStatus.BAD_REQUEST) // -- > para el bad request, Usualmente  400
    @ExceptionHandler(MethodArgumentNotValidException.class) // Captura la excepción de validación
    @ResponseBody   
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        // Itera sobre los errores de los campos no válidos
        ex.getBindingResult().getFieldErrors().forEach(error -> {   
            // Agrega los detalles de cada error: campo y mensaje
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return errors; // Devuelve el mapa con los errores como respuesta
    }
    
    //Manejamos la excepcion de TelefonoExistenteException
            //Nota flujo: UsuarioService detecta conflicto --> GlobalExceptionHandler  intecepta y devuelve --> Se muestra detalle del error
    @ExceptionHandler(TelefonoExistenteException.class)
    @ResponseBody
    public ErrorResponse handleTelefonoExistenteException(
            TelefonoExistenteException ex, HttpServletResponse response) {
        
        // Ponemos manualmente el código de estado HTTP en la respuesta
        response.setStatus(HttpStatus.CONFLICT.value()); //--> 409 para conflictos
        
        // Retornamos un ErrorResponse personalizado
        return new ErrorResponse(
            HttpStatus.CONFLICT.value(), // Código HTTP
            "La solicitud no se pudo procesar", // Descripción del error
            ex.getMessage() // Mensaje personalizado --> UsuarioService
        );
    }
}
