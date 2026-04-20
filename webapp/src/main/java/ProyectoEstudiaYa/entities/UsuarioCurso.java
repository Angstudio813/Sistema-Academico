package ProyectoEstudiaYa.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
 
@Entity
@Table(name = "usuario_cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class UsuarioCurso {

 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
 
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
 
    private Integer porcentajeCompletado = 0;
    private LocalDateTime fechaInscripcion;
    private LocalDateTime ultimaPractica;

}
