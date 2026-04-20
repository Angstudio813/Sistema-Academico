package ProyectoEstudiaYa.entities;

 
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
 
@Entity
@Table(name = "ejercicios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Ejercicio {

     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false, columnDefinition = "TEXT")
    private String pregunta;
 
    // Opciones de respuesta múltiple
    private String opcionA;
    private String opcionB;
    private String opcionC;
    private String opcionD;
 
    @Column(nullable = false)
    private String respuestaCorrecta; // "A", "B", "C" o "D"
 
    private String explicacion; // explicación de por qué es correcta
 
    @Enumerated(EnumType.STRING)
    private Dificultad dificultad; // FACIL, MEDIO, DIFICIL
 
    private Boolean generadoPorIA = false;
 
    @ManyToOne
    @JoinColumn(name = "tema_id", nullable = false)
    private Tema tema;
 
    @OneToMany(mappedBy = "ejercicio", cascade = CascadeType.ALL)
    private List<IntentoEjercicio> intentos;
 
    public enum Dificultad {
        FACIL, MEDIO, DIFICIL
    }

}
