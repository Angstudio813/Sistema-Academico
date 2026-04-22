package ProyectoEstudiaYa.webapp.repositories;

import ProyectoEstudiaYa.webapp.entities.Logro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface LogroRepository extends JpaRepository<Logro, Long> {

    List<Logro> findByUsuarioId(Long usuarioId);

    List<Logro> findByUsuarioIdAndTipo(Long usuarioId, Logro.TipoLogro tipo);

    long countByUsuarioId(Long usuarioId);

}
