package mission.view;

import mission.dto.ReservationOutputDTO;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static mission.config.GlobalVariable.FILL;
import static mission.config.GlobalVariable.NO_FILL;
import static mission.config.GlobalVariable.TABLE_RANGE_DAY;
import static mission.config.GlobalVariable.TODAY;

public class OutputView {
        public static final DateTimeFormatter detailFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        public static final DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MM/dd");

        public void printReservationList(List<ReservationOutputDTO> list) {
            System.out.println("\n예약 목록");
            System.out.println("|예약 시간\t\t\t\t|시작 시간\t\t\t\t|종료 시간\t\t\t\t|예약자 명\t\t\t");
            System.out.println("|-----------------------|-----------------------|-----------------------|-------------------|");

            int idx = 1;
            for (ReservationOutputDTO reservationOutputDTO : list) {
                System.out.printf("|%s\t|%s\t|%s\t|%s\t|\n",
                        reservationOutputDTO.savedAt().format(detailFormatter),
                        reservationOutputDTO.startTime().format(detailFormatter),
                        reservationOutputDTO.endTime().format(detailFormatter),
                        reservationOutputDTO.reservator());
            }
        }

        //7일 기간의 리스트를 받았다고 가정한 상황
        public void printReservationTable(List<List<Boolean>> list) {
            StringBuilder builder = new StringBuilder();

            builder.append("|날짜|");
            for(int i = 0; i<TABLE_RANGE_DAY; i++) {
                builder.append("|").append(TODAY.plusDays(i).format(monthFormatter));
            }
            builder.append("\n");

            for(int hour = 0; hour < 24; hour++) {
                builder.append("|").append(hour).append("~").append(hour+1).append("|");
                for(int i=0;i<7;i++){
                    //LocalDateTime date = LocalDateTime.of(TODAY.getYear(), TODAY.getMonth(), TODAY.getDayOfMonth()+i, hour, 0);

                    String stamp = list.get(i).get(hour) ? FILL : NO_FILL;

                    builder.append(stamp).append("|");
                }
                builder.append("\n");
            }
            builder.append("\n");
            System.out.print(builder);
        }
}
