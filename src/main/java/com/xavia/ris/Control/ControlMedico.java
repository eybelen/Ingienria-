package com.xavia.ris.Control;

import com.xavia.ris.Entidades.Medico;
import com.xavia.ris.Servicio.IMedicoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControlMedico {

  @Autowired
  private IMedicoServicio servicio;

  @RequestMapping("/Medico")
  public String verMedico(
    Model model,
    @Param("palBuscarMedico") String palBuscarMedico
  ) {
    List<Medico> listaMedico = servicio.listarMedico(palBuscarMedico);

    model.addAttribute("medicos", listaMedico);
    model.addAttribute("palBuscarMedico", palBuscarMedico);
    return "Medico_Gestionar";
  }

  @RequestMapping("/paginaMedico_Registrar")
  public String verMedico(Model model) {
    Medico medico = new Medico();
    model.addAttribute("registrarMedicoForm", medico);
    return "Medico_Registrar";
  }

  @PostMapping("/registrarMedico")
  public String registrarMedico(
    @ModelAttribute("registrarMedicoForm") Medico medico
  ) {
    servicio.registrarMedico(medico);
    return "redirect:/Medico";
  }

  @GetMapping("/editarMedico/{id}")
  public ModelAndView editarMedico(
    @PathVariable(name = "id") Long id,
    ModelAndView view
  ) {
    view.setViewName("Medico_Registrar");
    view.addObject("registrarMedicoForm", servicio.buscarPorId(id));
    return view;
  }

  @GetMapping("/eliminarMedico/{id}")
  public String eliminar(@PathVariable(name = "id") Long id) {
    servicio.eliminarPorId(id);
    return "redirect:/Medico";
  }
}
