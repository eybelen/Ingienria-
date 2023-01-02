package com.xavia.ris.Servicio;

import com.xavia.ris.Entidades.Usuario;
import java.util.List;

public interface IUsuarioServicio {
  public Usuario registrarUsuario(Usuario usuario);

  public List<Usuario> listarUsuario(String palBuscarUsuario);

  public void eliminarPorId(Long id);

  public Usuario buscarPorId(Long id);
}
