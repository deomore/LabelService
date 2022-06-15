package vlsu.ProducerCentr.serverside.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "releases")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Release extends BaseEntity {
	@Column(name = "name")
	private String name;
	@Column(name = "genre")
	private String genre;
	@Column(name = "release_url")
	private String releaseUrl;
	@ManyToOne
	@JoinColumn(name = "source_id")
	private Source source;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "artist_id")
	private Artist artist;
}
