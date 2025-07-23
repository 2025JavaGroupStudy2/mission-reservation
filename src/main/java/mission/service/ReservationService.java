package mission.service;

import java.util.List;
import mission.dto.ReservationInputDTO;
import mission.dto.ReservationOutputDTO;
import mission.model.Reservation;
import mission.repository.ReservationRepository;
import mission.validator.ReservationValidator;

public class ReservationService {
    ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public void saveReservation(ReservationInputDTO request) throws Exception{
        Reservation reservation = new Reservation(request.reservator(), request.startTime(), request.endTime());
        reservationRepository.save(reservation);
    }

    public List<ReservationOutputDTO> getCurrentReservations(){
        return reservationRepository.readAll();
    }

}
