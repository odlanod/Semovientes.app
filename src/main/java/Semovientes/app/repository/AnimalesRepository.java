package Semovientes.app.repository;

import Semovientes.app.model.Animal;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AnimalesRepository extends JpaRepository<Animal,Long>{

}
