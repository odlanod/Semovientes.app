package Semovientes.app.repository;
import Semovientes.app.model.Registro_Animales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroAnimalesRepository extends JpaRepository<Registro_Animales,Long> {
}
