package vlsu.ProducerCentr.serverside.model;

import liquibase.pro.packaged.E;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name = "contracts")
public class Contract extends BaseEntity {
	@Column(name = "date")
	private LocalDate date;
	@Column(name = "type")
	private Boolean type;
	@Column(name = "contract_url")
	private String contractUrl;
}
