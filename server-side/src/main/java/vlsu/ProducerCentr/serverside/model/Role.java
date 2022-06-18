package vlsu.ProducerCentr.serverside.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity(name = "roles")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
public class Role extends BaseEntity{
    @Column(name = "role_name")
    @Enumerated(value = EnumType.STRING)
    private RoleTitle title;
}
