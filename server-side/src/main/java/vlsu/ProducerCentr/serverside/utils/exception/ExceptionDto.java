package vlsu.ProducerCentr.serverside.utils.exception;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ExceptionDto {
    private String code;
    private String message;
}
