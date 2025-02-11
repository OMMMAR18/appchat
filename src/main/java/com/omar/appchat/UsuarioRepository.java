
package com.omar.appchat;

/**
 *
 * @author omar arroyo
 */

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UsuarioRepository  extends JpaRepository<Usuario, UUID>{
    
}
