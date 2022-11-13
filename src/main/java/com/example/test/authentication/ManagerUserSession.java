package com.example.test.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class ManagerUserSession {

    @Autowired
    HttpSession session;

    // Añadimos el id de usuario en la sesión HTTP para hacer
    // una autorización sencilla. En los métodos de controllers
    // comprobamos si el id del usuario logeado coincide con el obtenido
    // desde la URL
    public void logearUsuario(Long idUsuario) {
        session.setAttribute("idUsuarioLogeado", idUsuario);
    }

    public Long usuarioLogeado() {
        return (Long) session.getAttribute("idUsuarioLogeado");
    }

    public void logout() {
        session.setAttribute("idUsuarioLogeado", null);
    }
}
