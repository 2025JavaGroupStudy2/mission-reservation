package mission.view;

import api.Console;
import mission.dto.ReservationInputDTO;
import mission.validator.InputValidator;

public class InputView {
    public int inputMenuChoice(){
        System.out.println("------------------예약 시스템 메뉴------------------\n");
        System.out.println("1 : 예약 추가 | 2 : 예약 순서 | 3: 예약 현황 | 4 : 종료\n");
        String line = Console.readLine();
        return InputValidator.isMenuChoiceFormatCorrect(line);
    }

    public ReservationInputDTO inputReservationInfo() throws Exception {
        System.out.println("------------------------------------\n");
        System.out.println("       예약할 날짜를 입력해주세요.");
        String line = Console.readLine();
        //검증 후 반환된 변환값을 return해야함
        return InputValidator.isReservationRequestFormatCorrect(line);
    }
}
