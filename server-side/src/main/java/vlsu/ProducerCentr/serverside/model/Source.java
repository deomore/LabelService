package vlsu.ProducerCentr.serverside.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "sources")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Source extends BaseEntity{
	@Column(name = "source1url")
	private String source1Url;
	@Column(name = "source2url")
	private String source2Url;
	@Column(name = "source3url")
	private String source3Url;
}
