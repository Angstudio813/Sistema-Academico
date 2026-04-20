package ProyectoEstudiaYa.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
 
@Entity
@Table(name = "temas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false)
    private String nombre; // ej: Fracciones, Comprensión lectora
 
    private String descripcion;
    private Integer orden; // orden dentro del curso
 
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
 
    @OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
    private List<Ejercicio> ejercicios;
 
    @OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
    private List<Progreso> progresos;

}
