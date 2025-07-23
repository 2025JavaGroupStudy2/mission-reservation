package mission.validator;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import mission.config.GlobalVariable;
import mission.dto.ReservationInputDTO;
import mission.config.ExceptionMessage;

public class InputValidator {
    public static ReservationInputDTO isFormatCorrect(String line) {
        List<String> parts = Arrays.asList(line.split("\\s*-\\s*"));

        if(parts.size()<3) { throw new IllegalArgumentException(ExceptionMessage.INVALID_FORMAT); }

        LocalDateTime startTime = LocalDateTime.parse(parts.get(0));
        LocalDateTime endTime = LocalDateTime.parse(parts.get(1));
        String reservator = parts.get(2);

        if(startTime.isBefore(GlobalVariable.TODAY)) { throw new IllegalArgumentException(ExceptionMessage.INVALID_START_TIME);}
        if(endTime.isBefore(startTime)) { throw new IllegalArgumentException(ExceptionMessage.INVALID_DATE_SEQUENCE); }

        return new ReservationInputDTO(startTime, endTime, reservator);
    }
}
