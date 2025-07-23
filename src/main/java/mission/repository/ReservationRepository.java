package mission.repository;

import java.util.stream.Collectors;
import mission.dto.ReservationOutputDTO;
import mission.model.Reservation;

import java.util.ArrayList;
import java.util.List;
import mission.validator.ReservationValidator;

public class ReservationRepository{
    private final List<Reservation> reservations = new ArrayList<Reservation>();

    public void save(Reservation reservation){
        //bool 변수로 검증 후 저장
        ReservationValidator.validateOverlap(reservations, reservation);
        reservations.add(reservation);
    }

    public List<ReservationOutputDTO> readAll(){
        return reservations.stream().map(item -> new ReservationOutputDTO(
                                                            item.getTimeStart(),
                                                            item.getTimeEnd(),
                                                            item.getReservator(),
                                                            item.getSavedAt())).toList();
    }


}

