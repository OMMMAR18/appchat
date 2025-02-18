
package com.omar.appchat.service;

/**
 *
 * @author omar arroyo
 */

import com.omar.appchat.repository.UsuarioRepository;
import com.omar.appchat.model.Usuario;
import com.omar.appchat.exception.TelefonoExistenteException;
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
        
        if(usuarioRepository.existsByTelefono(usuario.getTelefono())){
             String telefono = usuario.getTelefono();
            throw new TelefonoExistenteException("El número de teléfono '" + telefono + "' ya está registrado.");
        }       
        // Hashea la contraseña antes de guardar el usuario
        String passwordHash = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passwordHash);
        
        usuario.setFechaAlta(OffsetDateTime.now()); // Asigna automáticamente la fecha de alta
        return usuarioRepository.save(usuario);//Inserta en BD        
    }
    
    // Método para consultar usuario por su ID
    //public Optional<Usuario> consultarUsuarioPorId(UUID id) {
    public Optional<Usuario> findByTelefono(String telefono) {    
        return usuarioRepository.findByTelefono(telefono);
    }
}