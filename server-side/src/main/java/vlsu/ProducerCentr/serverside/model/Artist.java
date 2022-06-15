package vlsu.ProducerCentr.serverside.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "artist")
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
}
