package mission.model;

import java.time.LocalDateTime;

public class Reservation {
    String reservator;
    LocalDateTime timeStart;
    LocalDateTime timeEnd;
    LocalDateTime savedAt;

    public Reservation(String reservator, LocalDateTime timeStart, LocalDateTime timeEnd){
        this.reservator = reservator;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.savedAt = LocalDateTime.now();
    }

    public String getReservator() {
        return reservator;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public LocalDateTime getSavedAt() {
        return savedAt;
    }
}
