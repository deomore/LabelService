package vlsu.ProducerCentr.serverside.utils.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vlsu.ProducerCentr.serverside.config.ApplicationProperties;
import vlsu.ProducerCentr.serverside.utils.exception.ErrorCode;
import vlsu.ProducerCentr.serverside.utils.validation.dto.RegistrationValidationDto;
import vlsu.ProducerCentr.serverside.utils.validation.helper.ValidationHelper;

import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class RegistrationValidator implements Validator<RegistrationValidationDto> {
    private final ApplicationProperties applicationProperties;
    @Override
    public void validate(RegistrationValidationDto target) {
        ValidationHelper.getInstance()
                .validate(
                        target.isLoginExists(),
                        Boolean.FALSE::equals,
                        ErrorCode.SUCH_LOGIN_ALREADY_EXISTS
                ).validate(
                        target.getLogin(),
                        (login) -> Pattern.matches(applicationProperties.getLoginRegEx(), login),
                        ErrorCode.WRONG_LOGIN_FORM
                ).validate(
                        target.getPassword(),
                        (password) -> Pattern.matches(applicationProperties.getPasswordRegEx(), password),
                        ErrorCode.WRONG_PASSWORD_FORM
                ).throwIfNotValid();
    }
}
