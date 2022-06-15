package vlsu.ProducerCentr.serverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vlsu.ProducerCentr.serverside.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}
