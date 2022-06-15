package vlsu.ProducerCentr.serverside.dto;

import lombok.Data;

@Data
public class AddReleaseDto {
	private String name;
	private String genre;
	private String releaseUrl;
	private Integer sourceId;
	private Integer artistId;
}
