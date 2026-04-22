package ProyectoEstudiaYa.webapp.repositories;

import ProyectoEstudiaYa.webapp.entities.Curso;
import ProyectoEstudiaYa.webapp.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    
    List<Curso> findByNivelAndGrado(Usuario.NivelEducativo nivel, Integer grado);

    List<Curso> findByNivel(Usuario.NivelEducativo nivel);
}
