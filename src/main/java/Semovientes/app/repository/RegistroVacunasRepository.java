package Semovientes.app.repository;
import Semovientes.app.model.Registro_Vacunas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroVacunasRepository extends JpaRepository<Registro_Vacunas,Long> {
}
