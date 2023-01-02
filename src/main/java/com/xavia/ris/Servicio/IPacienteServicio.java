package com.xavia.ris.Servicio;

import com.xavia.ris.Entidades.Paciente;
import java.util.List;

public interface IPacienteServicio {
  public Paciente admitirPaciente(Paciente paciente);

  public List<Paciente> listarPaciente(String palBuscarPaciente);

  /* public List<Paciente> listarParaCitaPaciente(Long id); */

  /* public List<Paciente> listarParaCitaPaciente(); */

  public void eliminarPorId(Long id);

  public Paciente buscarPorId(Long id);
}
