
package com.omar.appchat;

/**
 *
 * @author omar arroyo
 */

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder; // Inyectar el PasswordEncoder

    //Metodo para registrar usuario
    public Usuario registrarUsuario(Usuario usuario) {
        // Hashea la contraseña antes de guardar el usuario
        String passwordHash = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passwordHash);
        
        usuario.setFechaAlta(OffsetDateTime.now()); // Asigna automáticamente la fecha de alta
        return usuarioRepository.save(usuario);//Inserta en BD        
    }
    
    // Método para consultar usuario por su ID
    public Optional<Usuario> consultarUsuarioPorId(UUID id) {
        return usuarioRepository.findById(id);
    }
}
