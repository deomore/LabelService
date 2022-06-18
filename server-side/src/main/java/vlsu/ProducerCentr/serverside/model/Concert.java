package vlsu.ProducerCentr.serverside.model;

import liquibase.pro.packaged.C;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "concerts")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Concert extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "artist_id")
	private Artist artist;

	@Column(name = "city")
	private String city;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "price")
	private Float price;

	@OneToOne
	@JoinColumn(name = "release_id")
	private Release release;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
