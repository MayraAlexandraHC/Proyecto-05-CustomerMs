package com.bank.demo.api;

import com.bank.demo.model.Cliente;
import com.bank.demo.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link ClientesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-06T09:24:38.890396800-05:00[America/Lima]", comments = "Generator version: 7.10.0")
public interface ClientesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PUT /clientes/{id} : Actualizar información de un cliente
     *
     * @param id  (required)
     * @param cliente  (required)
     * @return Cliente actualizado exitosamente (status code 200)
     *         or Error de validación (status code 400)
     * @see ClientesApi#actualizarCliente
     */
    default ResponseEntity<Cliente> actualizarCliente(Integer id,
        Cliente cliente) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"apellido\" : \"apellido\", \"id\" : \"id\", \"nombre\" : \"nombre\", \"dni\" : \"dni\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"message\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /clientes : Crear un nuevo cliente
     *
     * @param cliente  (required)
     * @return Cliente creado exitosamente (status code 201)
     *         or Error de validación (status code 400)
     * @see ClientesApi#crearCliente
     */
    default ResponseEntity<Cliente> crearCliente(Cliente cliente) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"apellido\" : \"apellido\", \"id\" : \"id\", \"nombre\" : \"nombre\", \"dni\" : \"dni\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"message\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /clientes/{id} : Eliminar un cliente
     *
     * @param id  (required)
     * @return Cliente eliminado exitosamente (status code 204)
     *         or Error al eliminar cliente (status code 400)
     * @see ClientesApi#eliminarCliente
     */
    default ResponseEntity<Void> eliminarCliente(Integer id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"message\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /clientes : Listar todos los clientes
     *
     * @return Lista de clientes (status code 200)
     * @see ClientesApi#listarClientes
     */
    default ResponseEntity<List<Cliente>> listarClientes() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"apellido\" : \"apellido\", \"id\" : \"id\", \"nombre\" : \"nombre\", \"dni\" : \"dni\", \"email\" : \"email\" }, { \"apellido\" : \"apellido\", \"id\" : \"id\", \"nombre\" : \"nombre\", \"dni\" : \"dni\", \"email\" : \"email\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /clientes/{id} : Obtener detalles de un cliente por ID
     *
     * @param id  (required)
     * @return Detalles del cliente (status code 200)
     *         or Cliente no encontrado (status code 404)
     * @see ClientesApi#obtenerCliente
     */
    default ResponseEntity<Cliente> obtenerCliente(Integer id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"apellido\" : \"apellido\", \"id\" : \"id\", \"nombre\" : \"nombre\", \"dni\" : \"dni\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"message\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
