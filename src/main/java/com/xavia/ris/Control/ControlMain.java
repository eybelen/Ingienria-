package com.xavia.ris.Control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControlMain {

  @RequestMapping("/")
  public String verPrincipal(Model model) {
    return "Principal";
  }
}
