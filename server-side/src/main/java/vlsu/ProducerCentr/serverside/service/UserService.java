package vlsu.ProducerCentr.serverside.service;

import vlsu.ProducerCentr.serverside.dto.user.ChangePersonalInfoDto;
import vlsu.ProducerCentr.serverside.dto.user.PersonalInfoDto;
import vlsu.ProducerCentr.serverside.dto.user.RegistrationDto;
import vlsu.ProducerCentr.serverside.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    void register(RegistrationDto registrationDto);
    User findByLogin(String login);
    User findByExternalId(UUID externalId);
    List<User> getClientsOfUser();
    void changePersonalInfo(ChangePersonalInfoDto changePersonalInfoDto);
    PersonalInfoDto getPersonalInfo();
}
