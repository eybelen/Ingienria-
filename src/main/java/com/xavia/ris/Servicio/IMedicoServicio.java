package com.xavia.ris.Servicio;

import com.xavia.ris.Entidades.Medico;
import java.util.List;

public interface IMedicoServicio {
  public Medico registrarMedico(Medico medico);

  public List<Medico> listarMedico(String palBuscarMedico);

  public List<Medico> listarParaCitaMedico();

  public void eliminarPorId(Long id);

  public Medico buscarPorId(Long id);
}
