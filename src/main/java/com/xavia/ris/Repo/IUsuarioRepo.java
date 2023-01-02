package com.xavia.ris.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xavia.ris.Entidades.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Long> {
    @Query(
        "SELECT u FROM Usuario u WHERE u.username LIKE %?1%" +
        "OR u.rol LIKE %?1%"
      )
      public List<Usuario> findAll(String palBuscarUsuario);
}
