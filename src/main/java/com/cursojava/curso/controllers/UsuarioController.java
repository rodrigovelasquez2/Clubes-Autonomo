package com.cursojava.curso.controllers;

import com.cursojava.curso.DAO.UsuarioDAO;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.cursojava.curso.ENUM.*;

import java.util.List;

/**
 * Clase que maneja las solicitudes HTTP relacionadas con los usuarios.
 * @autor Rodrigo Andres Velasquez Quiroz
 * @date 27/09/2023
 */
@RestController
public class UsuarioController {

    @Autowired
    @Qualifier("usuarioService")
    private UsuarioDAO usuarioDAO;

    @Autowired
    private JWTUtil jwtUtil;

    /**
     * Obtiene la lista de usuarios.
     * @param token El token de autorización.
     * @return La lista de usuarios si el token es válido; de lo contrario, null.
     */
    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token) {
        if (!validarToken(token)) {
            return null; // Si el token no es válido, se retorna null
        }
        return usuarioDAO.getUsuarios();
    }

    /**
     * Valida un token de autorización.
     * @param token El token a validar.
     * @return true si el token es válido; de lo contrario, false.
     */
    private boolean validarToken(String token) {
        String usuarioid = jwtUtil.getKey(token);
        return usuarioid != null; // Retorna true si el token es válido; de lo contrario, false
    }

    /**
     * Registra un nuevo usuario en la base de datos.
     * @return  usuario El usuario a registrar.
     */
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuario.setRol(String.valueOf(Rol.USUARIO)); // Se añade el rol de usuarios
        usuarioDAO.registrar(usuario);
        return usuario;
    }

    /**
     * Elimina un usuario por su ID.
     * @param token El token de autorización.
     * @param id El ID del usuario a eliminar.
     */
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) {
        if (!validarToken(token)) {
            return; // Si el token no es válido, se sale temprano sin ejecutar la eliminación
        }
        usuarioDAO.eliminar(id);
    }
}
