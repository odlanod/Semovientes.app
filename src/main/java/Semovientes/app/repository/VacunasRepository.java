package Semovientes.app.repository;

import Semovientes.app.model.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacunasRepository extends JpaRepository<Vacuna, Long> {
}
