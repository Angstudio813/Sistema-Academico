package ProyectoEstudiaYa.webapp.repositories;

import ProyectoEstudiaYa.webapp.entities.Progreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProgresoRepository extends JpaRepository<Progreso, Long> {
    List<Progreso> findByUsuarioId(Long usuarioId);

    Optional<Progreso> findByUsuarioIdAndTemaId(Long usuarioId, Long temaId);

    // la IA usa esto para saber qué temas reforzar
    List<Progreso> findByUsuarioIdAndNecesitaRefuerzo(Long usuarioId, Boolean necesitaRefuerzo);

}
