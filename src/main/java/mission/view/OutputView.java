package mission.view;

import mission.dto.ReservationInputDTO;
import mission.dto.ReservationOutputDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static mission.config.GlobalVariable.TODAY;

public class OutputView {
        public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        public void printReservationList(List<ReservationOutputDTO> list) {
            System.out.println("\n예약 목록");
            System.out.println("|예약 시간\t\t\t\t|시작 시간\t\t\t\t|종료 시간\t\t\t\t|예약자 명\t\t\t");
            System.out.println("|-----------------------|-----------------------|-----------------------|-------------------|");

            int idx = 1;
            for (ReservationOutputDTO reservationOutputDTO : list) {
                System.out.printf("|%s\t|%s\t|%s\t|%s\t|\n",
                        reservationOutputDTO.savedAt().format(formatter),
                        reservationOutputDTO.startTime().format(formatter),
                        reservationOutputDTO.endTime().format(formatter),
                        reservationOutputDTO.reservator());
            }
        }

        public void printReservationTable(List<ReservationOutputDTO> list) {
            StringBuilder builder = new StringBuilder();

            builder.append("|날짜|");
            for(int i = 0; i < 7; i++) {
                builder.append("|").append(TODAY.plusDays(i));
            }
            builder.append("\n");

            for(int hour = 0; hour < 24; hour++) {
                builder.append("|").append(hour).append("~").append(hour+1).append("|");
                for(int i=0;i<7;i++){

                    LocalDateTime localDateTime = list.get(i).startTime();
                    if(list.get(i).startTime()<=TODAY.plusDays(). && list.get(i).endTime()>=hour){

                    }
                    builder.append("□").append("|");
                }

            }

            System.out.print(builder);
        }
}
