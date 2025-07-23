package mission;

import api.Console;
import mission.config.AppConfig;
import mission.view.InputView;

public class Application {
    public static void main(String[] args) {
        Application.run();
        //TODO: 미션 구현
    }

    public static void run(){
        InputView inputView = AppConfig.inputView();
    }
}