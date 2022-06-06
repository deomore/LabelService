package vlsu.ProducerCentr.serverside.utils.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import vlsu.ProducerCentr.serverside.config.ApplicationProperties;
import vlsu.ProducerCentr.serverside.dto.user.ChangePersonalInfoDto;
import vlsu.ProducerCentr.serverside.dto.user.ChangeablePersonalInfo;
import vlsu.ProducerCentr.serverside.model.Gender;
import vlsu.ProducerCentr.serverside.utils.exception.ErrorCode;
import vlsu.ProducerCentr.serverside.utils.validation.helper.ValidationHelper;

import java.util.Objects;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class ChangePersonalInfoValidator implements Validator<ChangePersonalInfoDto> {
    private final ApplicationProperties applicationProperties;
    @Override
    public void validate(ChangePersonalInfoDto target) {
        ValidationHelper helper = ValidationHelper.getInstance();
        String email = target.getInfoToChange().get(ChangeablePersonalInfo.EMAIL);
        if(Objects.nonNull(email)) {

        }
        String gender = target.getInfoToChange().get(ChangeablePersonalInfo.GENDER);
        if(Objects.nonNull(gender)) {
            try {
                Gender.valueOf(gender);
            } catch (IllegalArgumentException e) {
                helper.addCode(ErrorCode.UNEXPECTED_GENDER);
            }
        }

        helper.throwIfNotValid();
    }
}
