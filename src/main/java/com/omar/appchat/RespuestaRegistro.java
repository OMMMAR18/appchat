
package com.omar.appchat;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author omar arroyo
 */
public class RespuestaRegistro {
    private String mensaje;
    private Usuario usuario;
    
     public RespuestaRegistro(){
    }
    
    public RespuestaRegistro(String mensaje, Usuario usuario){
        this.mensaje = mensaje;
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
           
}
