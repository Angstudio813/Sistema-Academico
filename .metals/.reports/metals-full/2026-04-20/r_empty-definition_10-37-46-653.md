error id: file:///C:/Users/Usuario/Documents/GitHub/Estudia-Ya/webapp/src/main/java/ProyectoEstudiaYa/entities/Curso.java:_empty_/Data#
file:///C:/Users/Usuario/Documents/GitHub/Estudia-Ya/webapp/src/main/java/ProyectoEstudiaYa/entities/Curso.java
empty definition using pc, found symbol in pc: _empty_/Data#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 152
uri: file:///C:/Users/Usuario/Documents/GitHub/Estudia-Ya/webapp/src/main/java/ProyectoEstudiaYa/entities/Curso.java
text:
```scala
package ProyectoEstudiaYa.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
 
@Entity
@Table(name = "cursos")
@Da@@ta
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

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Data#