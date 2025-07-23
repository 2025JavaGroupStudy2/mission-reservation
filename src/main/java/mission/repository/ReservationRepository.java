package mission.repository;

import mission.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepository{
    private final List<Reservation> reservations = new ArrayList<Reservation>();

    public void save(Reservation reservation){
        reservations.add(reservation);
    }


}

