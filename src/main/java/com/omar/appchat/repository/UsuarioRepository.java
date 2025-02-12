
package com.omar.appchat.repository;

/**
 *
 * @author omar arroyo
 */

import com.omar.appchat.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UsuarioRepository  extends JpaRepository<Usuario, UUID>{
    boolean existsByTelefono(String telefono);
}
