package com.omar.appchat.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.omar.appchat.model.Usuario;
import com.omar.appchat.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.Key;

/**
 *
 * @author omar arroyo
 */
@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;//--> hace  la conexión a BD
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // --> comparamos las contraseñas
    
    private static final String SECRET_KEY = "bWljbGF2ZXNlZ3VyYTpBMzJCeXRlc0VuQmFzZTY0ISE="; // --> cambiar a dinámico
    Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    
    public String login(String telefono, String password) {
        Usuario usuario = usuarioRepository.findByTelefono(telefono).orElse(null);
        
        if (usuario == null) {
        throw new RuntimeException("Usuario no encontrado");
    }

        if (usuario != null && passwordEncoder.matches(password, usuario.getPassword())) {
            return generarToken(usuario);
        } else {
            throw new RuntimeException("Contraseña incorrecta");
        }
    }

    private String generarToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getTelefono())
                .setIssuedAt(new Date()) //fecha emisión
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // Fecha de expiración --> (1 hora)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // Algoritmo --> firma y clave secreta
                .compact(); // --> genera el token

    }

}
