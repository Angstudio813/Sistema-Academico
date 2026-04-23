package ProyectoEstudiaYa.webapp.services;

import ProyectoEstudiaYa.webapp.dto.AsistenteIARespuestaDTO;
import ProyectoEstudiaYa.webapp.entities.Progreso;
import ProyectoEstudiaYa.webapp.repositories.ProgresoRepository;
import ProyectoEstudiaYa.webapp.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsistenteIAService {

    private final UsuarioRepository usuarioRepository;
    private final ProgresoRepository progresoRepository;

    public AsistenteIAService(UsuarioRepository usuarioRepository, ProgresoRepository progresoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.progresoRepository = progresoRepository;
    }

    public AsistenteIARespuestaDTO generarAsistencia(Long usuarioId) {
        usuarioRepository.findById(usuarioId);
        String nombreUsuario = "estudiante";

        List<Progreso> temasConRefuerzo = progresoRepository.findByUsuarioIdAndNecesitaRefuerzo(usuarioId, true);
        List<String> temasRefuerzo = new ArrayList<>();

        String mensajePrincipal = construirMensajePrincipal(nombreUsuario, temasConRefuerzo.size());
        List<String> recomendaciones = construirRecomendaciones(temasRefuerzo);

        return new AsistenteIARespuestaDTO(
                usuarioId,
                nombreUsuario,
                mensajePrincipal,
                temasRefuerzo,
                recomendaciones
        );
    }

    private String construirMensajePrincipal(String nombreUsuario, int temasConRefuerzo) {
        if (temasConRefuerzo == 0) {
            return "Buen trabajo, " + nombreUsuario + ". No hay temas críticos por reforzar hoy.";
        }

        return "Hola " + nombreUsuario + ", detecté " + temasConRefuerzo + " tema(s) que conviene reforzar primero.";
    }

    private List<String> construirRecomendaciones(List<String> temasRefuerzo) {
        List<String> recomendaciones = new ArrayList<>();

        if (temasRefuerzo.isEmpty()) {
            recomendaciones.add("Resuelve 5 ejercicios de dificultad media para mantener ritmo.");
            recomendaciones.add("Repasa un tema dominado y explica el procedimiento en voz alta.");
            recomendaciones.add("Define una meta corta de 20 minutos de estudio activo.");
            return recomendaciones;
        }

        recomendaciones.add("Empieza por 10 minutos del tema con menor porcentaje de acierto.");
        recomendaciones.add("Resuelve 5 ejercicios guiados antes de pasar a ejercicios mixtos.");
        recomendaciones.add("Cierra con un mini repaso de errores frecuentes de hoy.");

        return recomendaciones;
    }
}
