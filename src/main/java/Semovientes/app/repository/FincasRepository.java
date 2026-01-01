
package Semovientes.app.repository;

import Semovientes.app.model.Fincas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FincasRepository extends JpaRepository<Fincas, Integer> {
}
