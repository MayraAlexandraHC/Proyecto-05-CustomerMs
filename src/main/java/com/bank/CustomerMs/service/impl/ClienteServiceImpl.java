package com.bank.CustomerMs.service.impl;

import com.bank.CustomerMs.client.CuentaClient;
import com.bank.CustomerMs.exception.ClienteException;
import com.bank.CustomerMs.model.Cliente;
import com.bank.CustomerMs.repository.ClienteRepository;
import com.bank.CustomerMs.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    private final CuentaClient cuentaClient;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        validarDatosCliente(cliente);
        if (clienteRepository.existsByDni(cliente.getDni())) {
            throw new ClienteException("Ya existe un cliente con este DNI");
        }
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new ClienteException("Ya existe un cliente con este correo");
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerClientePorId(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteException("Cliente no encontrado"));
    }

    @Override
    public Cliente actualizarCliente(Integer id, Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteException("Cliente no encontrado"));

        validarDatosCliente(cliente);

        if (!clienteExistente.getDni().equals(cliente.getDni()) &&
                clienteRepository.existsByDni(cliente.getDni())) {
            throw new ClienteException("Ya existe un cliente con este DNI");
        }

        if (!clienteExistente.getDni().equals(cliente.getDni()) &&
                clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new ClienteException("Ya existe un cliente con este correo");
        }

        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellido(cliente.getApellido());
        clienteExistente.setDni(cliente.getDni());
        clienteExistente.setEmail(cliente.getEmail());

        return clienteRepository.save(clienteExistente);
    }

    @Override
    public void eliminarCliente(Integer id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteException("Cliente no encontrado"));

        if (cuentaClient.tieneCuentasActivas(id)) {
            throw new ClienteException("No se puede eliminar el cliente porque tiene cuentas activas");
        }

        clienteRepository.deleteById(id);
    }

    private void validarDatosCliente(Cliente cliente) {
        if (cliente.getDni() == null || !cliente.getDni().matches("^[0-9]{8}$")) {
            throw new ClienteException("El DNI debe contener exactamente 8 dígitos numéricos");
        }
        if (cliente.getEmail() == null || !cliente.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new ClienteException("Formato de email inválido");
        }
    }
}