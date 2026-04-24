package ProyectoEstudiaYa.webapp.controller;

import ProyectoEstudiaYa.webapp.dto.AsistenteIARespuestaDTO;
import ProyectoEstudiaYa.webapp.services.AsistenteIAService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asistente-ia")
public class AsistenteIAController {

    private final AsistenteIAService asistenteIAService;

    public AsistenteIAController(AsistenteIAService asistenteIAService) {
        this.asistenteIAService = asistenteIAService;
    }

    // GET /asistente-ia/{usuarioId} — carga la vista con recomendaciones
    @GetMapping("/{usuarioId}")
    public String verAsistente(@PathVariable Long usuarioId, Model model) {
        AsistenteIARespuestaDTO asistencia = asistenteIAService.generarAsistencia(usuarioId);
        model.addAttribute("asistencia", asistencia);
        return "asistente-ia";
    }

    // POST /asistente-ia/chat — el alumno hace una pregunta libre
    @PostMapping("/chat")
    public String chat(@RequestParam Long usuarioId,
                       @RequestParam String pregunta,
                       Model model) {
        AsistenteIARespuestaDTO asistencia = asistenteIAService.generarAsistencia(usuarioId);
        model.addAttribute("asistencia", asistencia);

        String respuesta = asistenteIAService.chatLibre(usuarioId, pregunta);
        model.addAttribute("respuestaChat", respuesta);
        model.addAttribute("preguntaRealizada", pregunta);

        return "asistente-ia";
    }

    // GET /asistente-ia/api/{usuarioId} — endpoint REST (para Angular después)
    @GetMapping("/api/{usuarioId}")
    @ResponseBody
    public AsistenteIARespuestaDTO obtenerAsistenciaApi(@PathVariable Long usuarioId) {
        return asistenteIAService.generarAsistencia(usuarioId);
    }
}