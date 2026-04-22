package ProyectoEstudiaYa.webapp.repositories;

import ProyectoEstudiaYa.webapp.entities.IntentoEjercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
 
@Repository
public interface IntentoEjercicioRepository extends JpaRepository<IntentoEjercicio, Long> {
    
    List<IntentoEjercicio> findByUsuarioId(Long usuarioId);
    List<IntentoEjercicio> findByUsuarioIdAndEjercicioId(Long usuarioId, Long ejercicioId);
    long countByUsuarioIdAndEsCorrecta(Long usuarioId, Boolean esCorrecta);

}
