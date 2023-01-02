package com.xavia.ris.Servicio;

import com.xavia.ris.Entidades.Equipo;
import java.util.List;

public interface IEquipoServicio {
  public Equipo agregarEquipo(Equipo equipo);

  public List<Equipo> listarEquipo(String palBuscarEquipo);

  public List<Equipo> listarParaCitaEquipo();

  public void eliminarPorId(Long id);

  public Equipo buscarPorId(Long id);
}
