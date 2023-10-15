package com.cursojava.curso.controllers;
import com.cursojava.curso.DAO.UsuarioDAO;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    @Qualifier("usuarioService")
    private UsuarioDAO usuarioDAO;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
       public Map<String, Object> login(@RequestBody Usuario usuario) {
        Usuario usuarioLogeado = usuarioDAO.obtenerUsuarioPorCredenciales(usuario);

        if (usuarioLogeado != null) {
            // Si el usuarioLogeado no es nulo, crea un token JWT con su ID y email.
            String tokenJWT = jwtUtil.create(String.valueOf(usuarioLogeado.getId()), usuarioLogeado.getEmail());

            // Devuelve un mapa con el tokenJWT y el usuarioLogeado.
            return Map.of("tokenJWT", tokenJWT, "usuario", usuarioLogeado);
        }//Fin if

        // Si usuarioLogeado es nulo, devuelve un mapa con un mensaje "FAIL".
        return Map.of("mensaje", "FAIL");

    }//Fin Usuario
}//Fin AuthController
