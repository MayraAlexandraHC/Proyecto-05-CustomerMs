package com.bank.CustomerMs.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.validation.BindingResult;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

    @Mock
    private MethodArgumentNotValidException methodArgumentNotValidException;

    @Mock
    private BindingResult bindingResult;

    @Test
    void handleClienteException_RetornaErrorResponse() {
        ClienteException exception = new ClienteException("Error de prueba");

        ResponseEntity<GlobalExceptionHandler.ErrorResponse> response = exceptionHandler.handleClienteException(exception);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Error de prueba", response.getBody().getMessage());
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getBody().getStatus());
    }

    @Test
    void handleValidationExceptions_RetornaMapaErrores() {
        when(methodArgumentNotValidException.getBindingResult()).thenReturn(bindingResult);
        FieldError fieldError = new FieldError("cliente", "dni", "DNI inválido");
        when(bindingResult.getAllErrors()).thenReturn(java.util.Collections.singletonList(fieldError));

        ResponseEntity<Map<String, String>> response =
                exceptionHandler.handleValidationExceptions(methodArgumentNotValidException);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().containsKey("dni"));
        assertEquals("DNI inválido", response.getBody().get("dni"));
    }
}