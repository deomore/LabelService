package vlsu.ProducerCentr.serverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vlsu.ProducerCentr.serverside.model.Concert;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Integer> {
}
