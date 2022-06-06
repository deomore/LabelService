package vlsu.ProducerCentr.serverside.utils.mappers.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import vlsu.ProducerCentr.serverside.dto.user.RegistrationDto;
import vlsu.ProducerCentr.serverside.model.Role;

@Data
@Accessors(chain = true)
public class RegistrationMappingDto {
    private RegistrationDto dto;
    private Role role;
}
