package ProyectoEstudiaYa.webapp.dto;

import java.util.List;

public record ProgresoResumenDTO(
        Long usuarioId,
        int totalTemas,
        double promedioAcierto,
        long temasEnRefuerzo,
        long ejerciciosCorrectos,
        long logrosTotales,
        List<ProgresoTemaDTO> detalleTemas
) {
}
