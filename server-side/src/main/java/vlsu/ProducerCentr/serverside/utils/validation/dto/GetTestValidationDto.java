package vlsu.ProducerCentr.serverside.utils.validation.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GetTestValidationDto {
    private boolean isTestExist;
    private boolean isLanguageExist;
}
