package vlsu.ProducerCentr.serverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vlsu.ProducerCentr.serverside.model.Role;
import vlsu.ProducerCentr.serverside.model.RoleTitle;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByTitle(RoleTitle title);
}
