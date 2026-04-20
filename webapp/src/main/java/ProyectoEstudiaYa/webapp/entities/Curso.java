package ProyectoEstudiaYa.webapp.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
 
@Entity
@Table(name = "cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Curso {

 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false)
    private String nombre; // Matemática, Comunicación, etc.
 
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Usuario.NivelEducativo nivel; // PRIMARIA, SECUNDARIA
 
    @Column(nullable = false)
    private Integer grado; // 1 al 6 o 1 al 5
 
    private String descripcion;
    private String colorHex;  // color por curso ej: #378ADD
    private String icono;     // emoji o nombre del icono
 
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Tema> temas;
 
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<UsuarioCurso> usuarios;
 
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Tarea> tareas;


}
