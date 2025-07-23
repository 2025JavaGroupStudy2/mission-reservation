package mission.repository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import mission.dto.ReservationOutputDTO;
import mission.model.Reservation;

import java.util.ArrayList;
import java.util.List;
import mission.validator.ReservationValidator;

public class ReservationRepository{
    private final List<Reservation> reservations = new ArrayList<>();

    public void save(Reservation reservation){
        ReservationValidator.validateOverlap(reservations, reservation);
        reservations.add(reservation);
    }

    public List<ReservationOutputDTO> readRange(LocalDateTime startTime, int range){
        int nowHour = startTime.getHour();
        LocalDateTime endBound = startTime.plusDays(range).plusHours(24-nowHour);
        Function<LocalDateTime, Boolean> isInbound = (time)->{return startTime.isBefore(time)&&endBound.isAfter(time);};
        return reservations.stream()
                .filter(reservation -> isInbound.apply(reservation.getTimeStart()))
                .sorted(Comparator.comparing(Reservation::getTimeStart))
                .map(i->new ReservationOutputDTO(i.getTimeStart(), i.getTimeEnd(), i.getReservator(), i.getSavedAt()))
                .toList();
    }

    public List<ReservationOutputDTO> readAll(){
        return reservations.stream().map(item -> new ReservationOutputDTO(
                                                            item.getTimeStart(),
                                                            item.getTimeEnd(),
                                                            item.getReservator(),
                                                            item.getSavedAt())).toList();
    }


}

