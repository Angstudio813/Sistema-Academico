package ProyectoEstudiaYa.webapp.repositories;

import ProyectoEstudiaYa.webapp.entities.SesionAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SesionAuditoriaRepository extends JpaRepository<SesionAuditoria, Long> {

    List<SesionAuditoria> findByUsuarioId(Long usuarioId);

    List<SesionAuditoria> findByUsuarioIdAndTipoEvento(Long usuarioId, SesionAuditoria.TipoEvento tipoEvento);

    // para ver cuántas veces salió del viewport durante una práctica
    long countByUsuarioIdAndTipoEvento(Long usuarioId, SesionAuditoria.TipoEvento tipoEvento);

}
