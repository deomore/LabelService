package vlsu.ProducerCentr.serverside.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import vlsu.ProducerCentr.serverside.model.RoleTitle;

import java.util.List;

@Data
@Accessors(chain = true)
public class AuthResponseDto {
	private String token;
	private List<String> roles;
}
