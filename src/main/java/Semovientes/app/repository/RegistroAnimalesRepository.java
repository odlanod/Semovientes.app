package Semovientes.app.repository;
import Semovientes.app.model.RegistroAnimales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroAnimalesRepository extends JpaRepository<RegistroAnimales,Long> {
}
