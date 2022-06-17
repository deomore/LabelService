package vlsu.ProducerCentr.serverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vlsu.ProducerCentr.serverside.model.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
}
