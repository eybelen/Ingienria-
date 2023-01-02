package com.xavia.ris.Control;

import com.xavia.ris.Entidades.Usuario;
import com.xavia.ris.Servicio.IUsuarioServicio;
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
public class ControlUsuario {

  @Autowired
  private IUsuarioServicio servicio;

  @RequestMapping("/Usuario")
  public String verUsuario(
    Model model,
    @Param("palBuscarUsuario") String palBuscarUsuario
  ) {
    List<Usuario> listaUsuario = servicio.listarUsuario(palBuscarUsuario);

    model.addAttribute("usuarios", listaUsuario);
    model.addAttribute("palBuscarUsuario", palBuscarUsuario);
    return "Usuario_Gestionar";
  }

  @RequestMapping("/paginaUsuario_Registrar")
  public String verUsuario(Model model) {
    Usuario usuario = new Usuario();
    model.addAttribute("registrarUsuarioForm", usuario);
    return "Usuario_Registrar";
  }

  @PostMapping("/registrarUsuario")
  public String registrarUsuario(
    @ModelAttribute("registrarUsuarioForm") Usuario usuario
  ) {
    servicio.registrarUsuario(usuario);
    return "redirect:/Usuario";
  }

  @GetMapping("/editarUsuario/{id}")
  public ModelAndView editarUsuario(
    @PathVariable(name = "id") Long id,
    ModelAndView view
  ) {
    view.setViewName("Usuario_Registrar");
    view.addObject("registrarUsuarioForm", servicio.buscarPorId(id));
    return view;
  }

  @GetMapping("/eliminarUsuario/{id}")
  public String eliminar(@PathVariable(name = "id") Long id) {
    servicio.eliminarPorId(id);
    return "redirect:/Usuario";
  }
}
