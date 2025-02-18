
package com.omar.appchat.model;

/**
 *
 * @author omar arroyo
 */
public class LoginRequest {
    private String telefono;
    private String password;

    // Getters y Setters
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
