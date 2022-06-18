package vlsu.ProducerCentr.serverside.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@MappedSuperclass
@Data
@Accessors(chain = true)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
}
