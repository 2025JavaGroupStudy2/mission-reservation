package mission.config;

import mission.repository.ReservationRepository;
import mission.service.ReservationService;
import mission.view.InputView;
import mission.view.OutputView;

public class AppConfig {
    public InputView inputView(){
        return new InputView();
    }

    public OutputView outputView(){
        return new OutputView();
    }

    private ReservationRepository reservationRepository(){
        return new ReservationRepository();
    }

    public ReservationService reservationService(){
        return new ReservationService(reservationRepository());
    }
}
