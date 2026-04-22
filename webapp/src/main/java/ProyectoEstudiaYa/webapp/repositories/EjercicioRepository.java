package ProyectoEstudiaYa.webapp.repositories;

import ProyectoEstudiaYa.webapp.entities.Ejercicio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
 
@Repository
public interface EjercicioRepository  extends JpaRepository<Ejercicio, Long> {
    
    List<Ejercicio> findByTemaId(Long temaId);
    List<Ejercicio> findByTemaIdAndDificultad(Long temaId, Ejercicio.Dificultad dificultad);
    List<Ejercicio> findByGeneradoPorIA(Boolean generadoPorIA);

}
