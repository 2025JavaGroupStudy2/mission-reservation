package mission.view;

import api.Console;
import mission.dto.ReservationInputDTO;
import mission.validator.InputValidator;

public class InputView {
    public ReservationInputDTO inputReservationInfo() throws Exception {
        System.out.println("예약할 날짜를 입력해주세요.\n>>");
        String line = Console.readLine();
        //검증 후 반환된 변환값을 return해야함
        return InputValidator.isFormatCorrect(line);
    }
}
