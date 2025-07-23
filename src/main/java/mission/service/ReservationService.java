package mission.service;

import static mission.config.GlobalVariable.TABLE_RANGE_DAY;
import static mission.config.GlobalVariable.TODAY;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import mission.dto.ReservationInputDTO;
import mission.dto.ReservationOutputDTO;
import mission.model.Reservation;
import mission.repository.ReservationRepository;

public class ReservationService {
    ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public void saveReservation(ReservationInputDTO request) throws Exception{
        Reservation reservation = new Reservation(request.reservator(), request.startTime(), request.endTime());
        reservationRepository.save(reservation);
    }

    public List<ReservationOutputDTO> getAllReservations(){
        return reservationRepository.readAll();
    }

    public List<List<Boolean>> getTableRangeReservations(){
        List<ReservationOutputDTO> rawData = reservationRepository.readRange(TODAY, TABLE_RANGE_DAY);
        System.out.println(rawData);
        List<List<Boolean>> result = new ArrayList<>();

        //result 초기화
        for(int i=0; i<TABLE_RANGE_DAY; i++){
            List<Boolean> oneDay = new ArrayList<>();
            for(int j=0; j<24; j++){
                oneDay.add(false);
            }
            result.add(oneDay);
        }

        for(ReservationOutputDTO reserve : rawData){
            int index = reserve.startTime().getDayOfMonth() - TODAY.getDayOfMonth();
            Duration duration = Duration.between(reserve.startTime(), reserve.endTime());
            int start = reserve.startTime().getHour();
            long range = duration.toHours();
            System.out.println(start+" "+range);
            List<Boolean> oneDay = result.get(index);

            for(int k = start-1; k<start+range; k++){ oneDay.set(k, true); }
        }

        return result;
    }

}
