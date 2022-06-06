package vlsu.ProducerCentr.serverside.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vlsu.ProducerCentr.serverside.config.MappingConfiguration;
import vlsu.ProducerCentr.serverside.model.User;
import vlsu.ProducerCentr.serverside.utils.mappers.dto.RegistrationMappingDto;

@Mapper(config = MappingConfiguration.class)
public interface RegistrationMapper {

    @Mapping(target = "name", source = "source.dto.name")
    @Mapping(target = "surname", source = "source.dto.surname")
    @Mapping(target = "middleName", source = "source.dto.middleName")
    @Mapping(target = "gender", source = "source.dto.gender")
    @Mapping(target = "role", source = "source.role")
    @Mapping(target = "login", source = "source.dto.login")
    @Mapping(target = "password", source = "source.dto.password")
    @Mapping(target = "email", source = "source.dto.email")
    User from(RegistrationMappingDto source);
}
