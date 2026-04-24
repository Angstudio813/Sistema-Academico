package ProyectoEstudiaYa.webapp.services;

import ProyectoEstudiaYa.webapp.dto.MisCursosDTO;
import ProyectoEstudiaYa.webapp.entities.Curso;
import ProyectoEstudiaYa.webapp.entities.Usuario;
import ProyectoEstudiaYa.webapp.repositories.CursoRepository;
import java.lang.reflect.Field;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MisCursosService {

    private final CursoRepository cursoRepository;

    public MisCursosService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<MisCursosDTO> listarCursos() {
        return cursoRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    public List<MisCursosDTO> listarPorNivelYGrado(Usuario.NivelEducativo nivel, Integer grado) {
        return cursoRepository.findByNivelAndGrado(nivel, grado)
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    private MisCursosDTO convertirADTO(Curso curso) {
        List<?> temas = obtenerCampo(curso, "temas", List.class);
        int totalTemas = temas == null ? 0 : temas.size();
        Usuario.NivelEducativo nivel = obtenerCampo(curso, "nivel", Usuario.NivelEducativo.class);

        return new MisCursosDTO(
                obtenerCampo(curso, "id", Long.class),
                obtenerCampo(curso, "nombre", String.class),
                obtenerCampo(curso, "descripcion", String.class),
                nivel == null ? "" : nivel.name(),
                obtenerCampo(curso, "grado", Integer.class),
                obtenerCampo(curso, "colorHex", String.class),
                obtenerCampo(curso, "icono", String.class),
                totalTemas);
    }

    private <T> T obtenerCampo(Object origen, String nombreCampo, Class<T> tipo) {
        try {
            Field field = origen.getClass().getDeclaredField(nombreCampo);
            field.setAccessible(true);
            return tipo.cast(field.get(origen));
        } catch (ReflectiveOperationException | ClassCastException ex) {
            return null;
        }
    }
}
