package emlakcepte.repository;

import emlakcepte.model.Realty;
import emlakcepte.model.enums.RealtyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RealtyRepository extends JpaRepository<Realty, Integer> {

    List<Realty> findAllByUserId(int id);

    List<Realty> findAllByStatus(RealtyType active);

}
