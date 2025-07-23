package mission.config;

public final class ExceptionMessage {
    //- 예약 날짜 범위가 맞지 않음.
    //- 시작 날짜가 종료 날짜보다 늦음.
    //- 입력 양식이 틀린 응답이 입력됨.
    //- 해당 시간에 예약이 존재함.
    public static final String INVALID_FORMAT = "올바른 형식으로 입력하세요.";
    public static final String INVALID_DATE_SEQUENCE = "시작 날짜가 종료 날짜보다 늦습니다.";
    public static final String INVALID_START_TIME = "예약 시간은 현재보다 미래여야합니다.";
}
