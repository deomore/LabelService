package vlsu.ProducerCentr.serverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vlsu.ProducerCentr.serverside.model.Release;

@Repository
public interface ReleaseRepository extends JpaRepository<Release, Integer> {
}
