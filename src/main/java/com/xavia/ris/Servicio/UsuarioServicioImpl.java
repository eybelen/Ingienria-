package com.xavia.ris.Servicio;

import com.xavia.ris.Entidades.Usuario;
import com.xavia.ris.Repo.IUsuarioRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio {

  @Autowired
  private IUsuarioRepo repo;

  @Override
  public Usuario registrarUsuario(Usuario usuario) {
    return repo.save(usuario);
  }

  @Override
  public List<Usuario> listarUsuario(String palBuscarUsuario) {
    if (palBuscarUsuario != null) {
      return repo.findAll(palBuscarUsuario);
    }
    return repo.findAll();
  }

  @Override
  public Usuario buscarPorId(Long id) {
    return repo.findById(id).get();
  }

  @Override
  public void eliminarPorId(Long id) {
    repo.deleteById(id);
  }
}
