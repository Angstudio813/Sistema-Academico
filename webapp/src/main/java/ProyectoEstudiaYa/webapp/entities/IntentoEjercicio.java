package ProyectoEstudiaYa.webapp.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
 
@Entity
@Table(name = "intentos_ejercicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class IntentoEjercicio {

      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
 
    @ManyToOne
    @JoinColumn(name = "ejercicio_id", nullable = false)
    private Ejercicio ejercicio;
 
    private String respuestaElegida; // "A", "B", "C" o "D"
    private Boolean esCorrecta;
    private LocalDateTime fechaIntento;
    private Integer tiempoSegundos; // cuánto tardó en responder

}
