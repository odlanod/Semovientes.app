package Semovientes.app.repository;

import Semovientes.app.model.Vacunas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacunasRepository extends JpaRepository<Vacunas,Integer> {
}
