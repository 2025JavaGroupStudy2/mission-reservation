package mission.dto;

import java.time.LocalDateTime;

public record ReservationOutputDTO(LocalDateTime startTime,
                                   LocalDateTime endTime,
                                   String reservator,
                                   LocalDateTime savedAt) {
}
