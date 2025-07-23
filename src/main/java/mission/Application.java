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

        try{
            ReservationInputDTO input = inputView.inputReservationInfo();
            reservationService.saveReservation(input);
            List<ReservationOutputDTO> output = reservationService.getCurrentReservations();
            outputView.printReservationList(output);

        } catch (Exception e){
            throw new RuntimeException(e.getClass().getName()+" : "+e.getMessage());
        }
    }
}