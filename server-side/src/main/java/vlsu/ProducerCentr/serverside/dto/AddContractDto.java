package vlsu.ProducerCentr.serverside.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddContractDto {
	private LocalDate date;
	private Boolean type;
	private String contractUrl;
}
