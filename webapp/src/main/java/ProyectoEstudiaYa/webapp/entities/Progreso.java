package ProyectoEstudiaYa.webapp.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
 
@Entity
@Table(name = "progresos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Progreso {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
 
    @ManyToOne
    @JoinColumn(name = "tema_id", nullable = false)
    private Tema tema;
 
    private Integer ejerciciosIntentados = 0;
    private Integer ejerciciosCorrectos = 0;
    private Double porcentajeAcierto = 0.0; // la IA usa esto para saber si reforzar
 
    private LocalDateTime ultimaPractica;
 
    // si porcentajeAcierto < 50 la IA genera más ejercicios de este tema
    private Boolean necesitaRefuerzo = false;

}
