package vlsu.ProducerCentr.serverside.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vlsu.ProducerCentr.serverside.config.ApplicationProperties;
import vlsu.ProducerCentr.serverside.dto.user.ChangePersonalInfoDto;
import vlsu.ProducerCentr.serverside.dto.user.ChangeablePersonalInfo;
import vlsu.ProducerCentr.serverside.dto.user.PersonalInfoDto;
import vlsu.ProducerCentr.serverside.dto.user.RegistrationDto;
import vlsu.ProducerCentr.serverside.model.Gender;
import vlsu.ProducerCentr.serverside.model.RoleTitle;
import vlsu.ProducerCentr.serverside.model.Test;
import vlsu.ProducerCentr.serverside.model.User;
import vlsu.ProducerCentr.serverside.repository.TestRepository;
import vlsu.ProducerCentr.serverside.repository.UserRepository;
import vlsu.ProducerCentr.serverside.service.AuthService;
import vlsu.ProducerCentr.serverside.service.RoleService;
import vlsu.ProducerCentr.serverside.service.TestService;
import vlsu.ProducerCentr.serverside.service.UserService;
import vlsu.ProducerCentr.serverside.utils.jwt.Claim;
import vlsu.ProducerCentr.serverside.utils.jwt.JwtProvider;
import vlsu.ProducerCentr.serverside.utils.mappers.RegistrationMapper;
import vlsu.ProducerCentr.serverside.utils.mappers.dto.RegistrationMappingDto;
import vlsu.ProducerCentr.serverside.utils.validation.Validator;
import vlsu.ProducerCentr.serverside.utils.validation.dto.RegistrationValidationDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final static Map<ChangeablePersonalInfo, ChangePersonalInfoFunction> CHANGE_PERSONAL_INFO_FUNCTIONS = Map.of(
        ChangeablePersonalInfo.NAME, User::setName,
        ChangeablePersonalInfo.SURNAME, User::setSurname,
        ChangeablePersonalInfo.MIDDLE_NAME, User::setMiddleName,
        ChangeablePersonalInfo.EMAIL, User::setEmail,
        ChangeablePersonalInfo.GENDER, (user, gender) -> user.setGender(Gender.valueOf(gender))
    );

    private final ApplicationProperties applicationProperties;
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final RoleService roleService;
    private final Validator<RegistrationValidationDto> registrationValidator;
    private final RegistrationMapper registrationMapper;
    private final JwtProvider jwtProvider;
    private final Validator<ChangePersonalInfoDto> changePersonalInfoValidator;
    private final TestRepository testRepository;
    @Override
    @Transactional
    public void register(RegistrationDto registrationDto) {
        registrationValidator.validate(
                new RegistrationValidationDto()
                        .setLogin(registrationDto.getLogin())
                        .setPassword(registrationDto.getPassword())
                        .setLoginExists(repository.existsByLogin(registrationDto.getLogin()))
        );
        registrationDto.setPassword(encoder.encode(registrationDto.getPassword()));
        User user = registrationMapper.from(
                new RegistrationMappingDto()
                        .setDto(registrationDto)
                        .setRole(roleService.findByTitle(RoleTitle.ROLE_CLIENT))
        );
        repository.save(user);
    }

    @Override
    public User findByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public User findByExternalId(UUID externalId) {
        return repository.findByExternalId(externalId);
    }

    @Override
    @Transactional
    public List<User> getClientsOfUser() {
        UUID externalId = UUID.fromString(jwtProvider.getClaimFromToken(Claim.EXTERNAL_ID).toString());;
        User user = findByExternalId(externalId);
        return repository.findAllByProducerCentrlogist(user);
    }

    @Override
    @Transactional
    public void changePersonalInfo(ChangePersonalInfoDto changePersonalInfoDto) {
        changePersonalInfoValidator.validate(changePersonalInfoDto);
        Map<ChangeablePersonalInfo, String> map = changePersonalInfoDto.getInfoToChange();
        User user = findByExternalId(UUID.fromString(jwtProvider.getClaimFromToken(Claim.EXTERNAL_ID).toString()));
        CHANGE_PERSONAL_INFO_FUNCTIONS.forEach((key, value) -> {
            if (map.containsKey(key)) {
                value.change(user, map.get(key));
            }
        });
    }

    @Override
    public PersonalInfoDto getPersonalInfo() {
        UUID clientId = UUID.fromString(jwtProvider.getClaimFromToken(Claim.EXTERNAL_ID).toString());
        User user = repository.findByExternalId(clientId);
        return new PersonalInfoDto()
                .setName(user.getName())
                .setEmail(user.getEmail())
                .setSurname(user.getSurname())
                .setMiddleName(user.getMiddleName())
                .setGender(user.getGender());
    }

    @FunctionalInterface
    private interface ChangePersonalInfoFunction {
        void change(User user, String newInfo);
    }
}
