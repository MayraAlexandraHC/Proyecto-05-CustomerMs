package com.bank.CustomerMs.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CuentaClientTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CuentaClient cuentaClient;

    @Test
    void tieneCuentasActivas_ClienteExistente_RetornaTrue() {
        when(restTemplate.getForObject(anyString(), eq(String.class)))
                .thenReturn("alguna respuesta");

        boolean resultado = cuentaClient.tieneCuentasActivas(1);

        assertTrue(resultado);
    }

    @Test
    void tieneCuentasActivas_ClienteNoExistente_RetornaFalse() {
        when(restTemplate.getForObject(anyString(), eq(String.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        boolean resultado = cuentaClient.tieneCuentasActivas(1);

        assertFalse(resultado);
    }

    @Test
    void tieneCuentasActivas_ErrorComunicacion_RetornaFalse() {
        when(restTemplate.getForObject(anyString(), eq(String.class)))
                .thenThrow(new RuntimeException("Error de comunicación"));

        boolean resultado = cuentaClient.tieneCuentasActivas(1);

        assertFalse(resultado);
    }
}