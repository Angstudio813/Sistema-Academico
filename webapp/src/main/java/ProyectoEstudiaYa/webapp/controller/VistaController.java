package ProyectoEstudiaYa.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaController {

    @GetMapping("/plan-estudio")
    public String planEstudio() {
        return "plan-estudio";
    }

    @GetMapping("/logros-retos")
    public String logrosRetos() {
        return "Logros-retos";
    }
}
