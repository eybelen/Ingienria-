package com.xavia.ris.Servicio;

import com.xavia.ris.Entidades.Cita;
import java.util.List;

public interface ICitaServicio {
  public Cita agregarCita(Cita cita);

  public List<Cita> listarCita(String palBuscarCita);

  public void eliminarPorId(Long id);

  public Cita buscarPorId(Long id);
}
