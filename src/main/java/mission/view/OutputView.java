package mission.view;

import mission.dto.ReservationInputDTO;
import mission.dto.ReservationOutputDTO;

import java.time.format.DateTimeFormatter;
import java.util.List;

    public class OutputView {
        public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        public void printReservationList(List<ReservationOutputDTO> list) {
            System.out.println("\n예약 목록");
            System.out.println("|예약 시간\t    \t\t|시작 시간\t\t    \t|종료 시간\t    \t\t|예약자 명\t|");
            System.out.println("|-----------------|-----------------|-----------------|---------|");

            int idx = 1;
            for (ReservationOutputDTO reservationOutputDTO : list) {
                System.out.printf("|%s\t|%s\t|%s\t|%s\t\n",
                        reservationOutputDTO.savedAt().format(formatter),
                        reservationOutputDTO.startTime().format(formatter),
                        reservationOutputDTO.endTime().format(formatter),
                        reservationOutputDTO.reservator());
            }
        }
}
