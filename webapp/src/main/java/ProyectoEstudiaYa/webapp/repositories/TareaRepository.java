package ProyectoEstudiaYa.webapp.repositories;

import ProyectoEstudiaYa.webapp.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
 
@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    
    List<Tarea> findByUsuarioId(Long usuarioId);
    List<Tarea> findByUsuarioIdAndEstado(Long usuarioId, Tarea.EstadoTarea estado);
    List<Tarea> findByUsuarioIdAndCursoId(Long usuarioId, Long cursoId);


}
