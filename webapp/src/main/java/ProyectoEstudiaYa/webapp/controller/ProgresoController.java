package ProyectoEstudiaYa.webapp.controller;

import ProyectoEstudiaYa.webapp.dto.ProgresoResumenDTO;
import ProyectoEstudiaYa.webapp.services.ProgresoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/progreso")
public class ProgresoController {

    private final ProgresoService progresoService;

    public ProgresoController(ProgresoService progresoService) {
        this.progresoService = progresoService;
    }

    @GetMapping("/{usuarioId}")
    public String verProgreso(@PathVariable Long usuarioId, Model model) {
        ProgresoResumenDTO progreso = progresoService.obtenerProgresoUsuario(usuarioId);
        model.addAttribute("progreso", progreso);
        return "progreso";
    }

    @GetMapping("/api/{usuarioId}")
    @ResponseBody
    public ProgresoResumenDTO obtenerProgresoApi(@PathVariable Long usuarioId) {
        return progresoService.obtenerProgresoUsuario(usuarioId);
    }
}
