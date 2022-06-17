package vlsu.ProducerCentr.serverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vlsu.ProducerCentr.serverside.model.DemoDrop;

@Repository
public interface DemoDropRepository extends JpaRepository<DemoDrop, Integer> {
}
