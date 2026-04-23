package ProyectoEstudiaYa.webapp.dto;

public record ProgresoTemaDTO(
        String tema,
        Integer ejerciciosIntentados,
        Integer ejerciciosCorrectos,
        Double porcentajeAcierto,
        Boolean necesitaRefuerzo
) {
}
