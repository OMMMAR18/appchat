
package com.omar.appchat.repository;

/**
 *
 * @author omar arroyo
 */

import com.omar.appchat.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

// findBy, existsBy, countBy, etc
public interface UsuarioRepository  extends JpaRepository<Usuario, UUID>{
    boolean existsByTelefono(String telefono);
    Optional<Usuario> findByTelefono(String telefono);
}
