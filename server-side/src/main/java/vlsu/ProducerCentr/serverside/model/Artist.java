package vlsu.ProducerCentr.serverside.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "artists")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Artist extends BaseEntity {
	@Column(name = "name")
	private String name;
	@Column(name = "fio")
	private String fio;
	@Column(name = "genre")
	private String genre;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	@JoinColumn(name = "contract_id")
	private Contract contract;
}
