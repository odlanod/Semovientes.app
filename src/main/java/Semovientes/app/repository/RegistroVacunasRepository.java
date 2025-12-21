package Semovientes.app.repository;
import Semovientes.app.model.RegistroVacunas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroVacunasRepository extends JpaRepository<RegistroVacunas,Long> {
}
