package ProyectoEstudiaYa.webapp.dto;

import java.util.List;

public record AsistenteIARespuestaDTO(
        Long usuarioId,
        String nombreUsuario,
        String mensajePrincipal,
        List<String> temasRefuerzo,
        List<String> recomendaciones        
) {
}
