package ProyectoEstudiaYa.webapp.controller;

import ProyectoEstudiaYa.webapp.dto.AsistenteIARespuestaDTO;
import ProyectoEstudiaYa.webapp.services.AsistenteIAService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/asistente-ia")
public class AsistenteIAController {

    private final AsistenteIAService asistenteIAService;

    public AsistenteIAController(AsistenteIAService asistenteIAService) {
        this.asistenteIAService = asistenteIAService;
    }

    @GetMapping("/{usuarioId}")
    public String verAsistente(@PathVariable Long usuarioId, Model model) {
        AsistenteIARespuestaDTO asistencia = asistenteIAService.generarAsistencia(usuarioId);
        model.addAttribute("asistencia", asistencia);
        return "asistente-ia";
    }

    @GetMapping("/api/{usuarioId}")
    @ResponseBody
    public AsistenteIARespuestaDTO obtenerAsistenciaApi(@PathVariable Long usuarioId) {
        return asistenteIAService.generarAsistencia(usuarioId);
    }
}
