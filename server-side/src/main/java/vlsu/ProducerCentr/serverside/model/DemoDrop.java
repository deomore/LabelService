package vlsu.ProducerCentr.serverside.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity(name = "demo_drop")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DemoDrop extends BaseEntity {
	@Column(name = "demo_url")
	private String demoUrl;
	@Column(name = "description")
	private String description;
	@Column(name = "mail")
	private String mail;
	@ManyToOne
	@JoinColumn(name = "contract_id")
	private Contract contract;
}
