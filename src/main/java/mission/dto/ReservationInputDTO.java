package mission.dto;

import java.time.LocalDateTime;

public record ReservationInputDTO(
        LocalDateTime startTime,
        LocalDateTime endTime,
        String reservator
) {}
