
package com.omar.appchat.model;

/**
 *
 * @author omar arroyo
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size; //para validar el tamaño
import jakarta.validation.constraints.Pattern;   //para validar digitos
import java.util.UUID;
import java.time.OffsetDateTime;     
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id // --> marca el campo como clave primaria
    @GeneratedValue //--> genera valores automáticas como IDs   
    @Column (name = "id_usuario", columnDefinition = "UUID", nullable = false)
    private UUID idUsuario;
    
    @Column (name = "nombre", columnDefinition = "TEXT", nullable = false)
    private String nombre;
  
    @Column (name = "apellido", columnDefinition = "TEXT", nullable = false)
    private String apellido;
        
    @Column (name = "telefono", columnDefinition = "TEXT", nullable = false, unique = true)
    @Size (min=10, max = 10, message="El numero de telefono debe tener 10 digitos")
    @Pattern(regexp = "^[0-9]+$", message = "El numero de telefono solo admite numeros")
    private String telefono;
    
    @Column (name = "password", columnDefinition = "TEXT", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Solo se incluye en la deserialización
    private String password;
    
    @Column (name = "fecha_alta", columnDefinition = "TIMESTAMPTZ", nullable = false)
    private OffsetDateTime fechaAlta;

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    // Inyectar el PasswordEncoder
    //@Autowired
    //private transient PasswordEncoder passwordEncoder;

    // Método setter para hashear el password
    public void setPassword(String password) {
        this.password = password;
    }

    
    // Método getter (no es necesario deshashear, ya que el hash es irreversible)
    @JsonIgnore // Evita que el password se incluya en la respuesta JSON
    public String getPassword() {
        return this.password;
    }

    public OffsetDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(OffsetDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    
    
}
