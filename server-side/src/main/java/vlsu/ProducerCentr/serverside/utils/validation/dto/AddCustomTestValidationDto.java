package vlsu.ProducerCentr.serverside.utils.validation.dto;

import liquibase.pro.packaged.A;
import lombok.Data;
import lombok.experimental.Accessors;
import vlsu.ProducerCentr.serverside.dto.test.custom.AddTestResultDto;

import java.util.List;

@Data
@Accessors(chain = true)
public class AddCustomTestValidationDto {
    private boolean isLanguageExists;
    private List<AddTestResultDto> results;
}
