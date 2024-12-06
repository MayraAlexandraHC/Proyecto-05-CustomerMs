package com.bank.demo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Cliente
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-06T09:24:38.890396800-05:00[America/Lima]", comments = "Generator version: 7.10.0")
public class Cliente {

  private String id;

  private String nombre;

  private String apellido;

  private String dni;

  private String email;

  public Cliente() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Cliente(String nombre, String apellido, String dni) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
  }

  public Cliente id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", accessMode = Schema.AccessMode.READ_ONLY, requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Cliente nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
   */
  @NotNull @Size(min = 2, max = 50) 
  @Schema(name = "nombre", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nombre")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Cliente apellido(String apellido) {
    this.apellido = apellido;
    return this;
  }

  /**
   * Get apellido
   * @return apellido
   */
  @NotNull @Size(min = 2, max = 50) 
  @Schema(name = "apellido", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("apellido")
  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public Cliente dni(String dni) {
    this.dni = dni;
    return this;
  }

  /**
   * Get dni
   * @return dni
   */
  @NotNull @Size(min = 8, max = 15) 
  @Schema(name = "dni", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dni")
  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public Cliente email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   */
  @jakarta.validation.constraints.Email 
  @Schema(name = "email", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cliente cliente = (Cliente) o;
    return Objects.equals(this.id, cliente.id) &&
        Objects.equals(this.nombre, cliente.nombre) &&
        Objects.equals(this.apellido, cliente.apellido) &&
        Objects.equals(this.dni, cliente.dni) &&
        Objects.equals(this.email, cliente.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, apellido, dni, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cliente {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    apellido: ").append(toIndentedString(apellido)).append("\n");
    sb.append("    dni: ").append(toIndentedString(dni)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

