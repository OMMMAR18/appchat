
package com.omar.appchat.controller;

import com.omar.appchat.model.LoginRequest;
import com.omar.appchat.model.Usuario;
import com.omar.appchat.service.LoginService;
import com.omar.appchat.service.UsuarioService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author omar arroyo
 */

@RestController
public class LoginController {
    
    @Autowired
    private LoginService loginService; //Inyecta UsuarioService en el controller
    
    @PostMapping("/api/v01/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
    String token = loginService.login(loginRequest.getTelefono(), loginRequest.getPassword());
    return ResponseEntity.ok(token);
        }catch (RuntimeException ex) {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
        }
    }
}
