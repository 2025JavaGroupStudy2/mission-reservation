package mission;

import api.Console;
import java.util.List;
import mission.config.AppConfig;
import mission.dto.ReservationInputDTO;
import mission.dto.ReservationOutputDTO;
import mission.service.ReservationService;
import mission.view.InputView;
import mission.view.OutputView;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Application.run(appConfig);
        //TODO: 미션 구현
    }

    public static void run(AppConfig appConfig){
        InputView inputView = appConfig.inputView();
        OutputView outputView = appConfig.outputView();
        ReservationService reservationService = appConfig.reservationService();
        boolean quit = false;

        try{
            do {
                int menu = inputView.inputMenuChoice();
                switch (menu) {
                    case 1:
                        ReservationInputDTO input = inputView.inputReservationInfo();
                        reservationService.saveReservation(input);
                        break;
                    case 2:
                        List<ReservationOutputDTO> output = reservationService.getCurrentReservations();
                        outputView.printReservationList(output);
                        break;
                    case 3:
                        List<ReservationOutputDTO> all = reservationService.getCurrentReservations();
                        outputView.printReservationTable(all);
                        break;
                    case 4:
                        quit = true;
                        break;
                }
            } while (!quit);

        } catch (Exception e){
            throw new RuntimeException(e.getClass().getName()+" : "+e.getMessage());
        }
    }
}