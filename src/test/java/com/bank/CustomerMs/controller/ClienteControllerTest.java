package com.bank.CustomerMs.controller;

import com.bank.CustomerMs.exception.ClienteException;
import com.bank.CustomerMs.model.Cliente;
import com.bank.CustomerMs.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = Cliente.builder()
                .id(1)
                .nombre("Juan")
                .apellido("Pérez")
                .dni("12345678")
                .email("juan@example.com")
                .build();
    }

    @Test
    void crearCliente_DatosValidos_RetornaClienteCreado() {
        when(clienteService.crearCliente(any(Cliente.class))).thenReturn(cliente);

        ResponseEntity<Cliente> response = clienteController.crearCliente(cliente);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(cliente.getDni(), response.getBody().getDni());
        verify(clienteService).crearCliente(any(Cliente.class));
    }

    @Test
    void listarClientes_ExistenClientes_RetornaLista() {
        List<Cliente> clientes = Collections.singletonList(cliente);
        when(clienteService.listarClientes()).thenReturn(clientes);

        ResponseEntity<List<Cliente>> response = clienteController.listarClientes();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void obtenerClientePorId_ClienteExiste_RetornaCliente() {
        when(clienteService.obtenerClientePorId(1)).thenReturn(cliente);

        ResponseEntity<Cliente> response = clienteController.obtenerCliente(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(cliente.getId(), response.getBody().getId());
    }

    @Test
    void actualizarCliente_DatosValidos_RetornaClienteActualizado() {
        when(clienteService.actualizarCliente(eq(1), any(Cliente.class))).thenReturn(cliente);

        ResponseEntity<Cliente> response = clienteController.actualizarCliente(1, cliente);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(cliente.getId(), response.getBody().getId());
    }

    @Test
    void eliminarCliente_ClienteExiste_RetornaNoContent() {
        doNothing().when(clienteService).eliminarCliente(1);

        ResponseEntity<Void> response = clienteController.eliminarCliente(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(clienteService).eliminarCliente(1);
    }

    @Test
    void crearCliente_DniInvalido_LanzaExcepcion() {
        Cliente clienteInvalido = Cliente.builder()
                .id(1)
                .nombre("Juan")
                .apellido("Pérez")
                .dni("123")  // DNI inválido
                .email("juan@example.com")
                .build();

        when(clienteService.crearCliente(any(Cliente.class)))
                .thenThrow(new ClienteException("DNI inválido"));

        assertThrows(ClienteException.class, () -> clienteController.crearCliente(clienteInvalido));
    }

    @Test
    void crearCliente_EmailInvalido_LanzaExcepcion() {
        Cliente clienteInvalido = Cliente.builder()
                .id(1)
                .nombre("Juan")
                .apellido("Pérez")
                .dni("12345678")
                .email("emailinvalido")  // Email inválido
                .build();

        when(clienteService.crearCliente(any(Cliente.class)))
                .thenThrow(new ClienteException("Email inválido"));

        assertThrows(ClienteException.class, () -> clienteController.crearCliente(clienteInvalido));
    }

}