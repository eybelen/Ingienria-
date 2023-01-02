package com.xavia.ris.Control;

import com.xavia.ris.Entidades.Equipo;
import com.xavia.ris.Servicio.IEquipoServicio;
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
public class ControlEquipo {

  @Autowired
  private IEquipoServicio servicio;

  @RequestMapping("/Equipo")
  public String verEquipo(
    Model model,
    @Param("palBuscarEquipo") String palBuscarEquipo
  ) {
    List<Equipo> listaEquipo = servicio.listarEquipo(palBuscarEquipo);

    model.addAttribute("equipos", listaEquipo);
    model.addAttribute("palBuscarEquipo", palBuscarEquipo);
    return "Equipo_Gestionar";
  }

  @RequestMapping("/paginaEquipo_Agregar")
  public String verEquipo(Model model) {
    Equipo equipo = new Equipo();
    model.addAttribute("agregarEquipoForm", equipo);
    return "Equipo_Agregar";
  }

  @PostMapping("/agregarEquipo")
  public String agregarEquipo(
    @ModelAttribute("agregarEquipoForm") Equipo equipo
  ) {
    servicio.agregarEquipo(equipo);
    return "redirect:/Equipo";
  }

  @GetMapping("/editarEquipo/{id}")
  public ModelAndView editar(
    @PathVariable(name = "id") Long id,
    ModelAndView view
  ) {
    view.setViewName("Equipo_Agregar");
    view.addObject("agregarEquipoForm", servicio.buscarPorId(id));

    return view;
  }

  @GetMapping("/eliminarEquipo/{id}")
  public String eliminar(@PathVariable(name = "id") Long id) {
    servicio.eliminarPorId(id);
    return "redirect:/Equipo";
  }
}
