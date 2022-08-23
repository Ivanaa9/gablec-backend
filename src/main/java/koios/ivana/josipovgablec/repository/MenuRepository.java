package koios.ivana.josipovgablec.repository;

import koios.ivana.josipovgablec.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuItem, Long> {
}
