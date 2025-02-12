
package com.omar.appchat.controller;

import com.omar.appchat.model.RespuestaRegistro;
import com.omar.appchat.model.Usuario;
import com.omar.appchat.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author omar arroyo
 */

@RestController
public class RegistroController {
    
    @Autowired
    private UsuarioService usuarioService; //@Autowired permite que UsuarioService se inyecte en el controller | permite que Spring gestione la instancia del servicio y la proporcione automáticamente.
    
    @PostMapping("/api/v01/register")
    public RespuestaRegistro registrarUsuario(@Valid @RequestBody Usuario usuario){ //@Valid @RequestBody Usuario usuario --> Valida el objeto Usuario recibido en el cuerpo de la solicitud.
    Usuario usuarioRegistrado = usuarioService.registrarUsuario(usuario);
     return new RespuestaRegistro("El usuario fue registrado exitosamente", usuarioRegistrado);// 
    }
    
}