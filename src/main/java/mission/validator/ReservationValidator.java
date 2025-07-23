package mission.validator;

import mission.model.Reservation;

import java.util.List;

import static mission.config.ExceptionMessage.INVALID_DATE_SEQUENCE;
import static mission.config.ExceptionMessage.RESERVATION_EXISTING;

//- 예약 날짜 범위가 맞지 않음.
//- 시작 날짜가 종료 날짜보다 늦음.
//- 해당 시간에 예약이 존재함.

public class ReservationValidator {
    public static void validateTimeOrder(Reservation reservation){
        if(reservation.getTimeEnd().isBefore(reservation.getTimeStart()) || reservation.getTimeEnd().isEqual(reservation.getTimeStart())){
            throw new IllegalArgumentException(INVALID_DATE_SEQUENCE);
        }
    }

    public static void validateOverlap(List<Reservation> existing,  Reservation reservation){
        for(Reservation res : existing){
            if(res.isOverlap(reservation)){
                throw new IllegalArgumentException(RESERVATION_EXISTING);
            }
        }
    }
}
