package mission.validator;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import mission.config.GlobalVariable;
import mission.dto.ReservationInputDTO;
import mission.config.ExceptionMessage;

public class InputValidator {
    public static int isMenuChoiceFormatCorrect(String line){
        try{
            return Integer.parseInt(line);
        }catch (Exception e){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_FORMAT);
        }
    }

    public static ReservationInputDTO isReservationRequestFormatCorrect(String line) {
        LocalDateTime startTime, endTime;
        String reservator;
        List<String> parts = Arrays.asList(line.split(" - "));

        if(parts.size()<3) { throw new IllegalArgumentException(ExceptionMessage.INVALID_FORMAT); }

        try{
            startTime = LocalDateTime.parse(parts.get(0));
            endTime = LocalDateTime.parse(parts.get(1));
            reservator = parts.get(2);

        }catch (Exception e){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_FORMAT);
        }

        if(startTime.isBefore(GlobalVariable.TODAY)) { throw new IllegalArgumentException(ExceptionMessage.INVALID_START_TIME);}
        if(endTime.isBefore(startTime)) { throw new IllegalArgumentException(ExceptionMessage.INVALID_DATE_SEQUENCE); }

        return new ReservationInputDTO(startTime, endTime, reservator);
    }
}
