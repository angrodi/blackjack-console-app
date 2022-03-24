package com.bytesw.blackjackconsoleapp.repository;

import com.bytesw.blackjackconsoleapp.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    boolean existsByCorreo(String email);
    Usuario findByCorreo(String email);

}
