package baseball.view;

import baseball.constant.Constants;

public class OutputView {

    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOT_THING = "낫싱";
    public static final String BASEBALL_GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String BASEBALL_GAME_END_MESSAGE = "%s개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public OutputView() {
    }

    public void printGameScore(Integer strike, Integer ball) {
        if (strike > 0 && ball > 0) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        } else if (strike > 0) {
            System.out.println(strike + STRIKE);
        } else if (ball > 0) {
            System.out.println(ball + BALL);
        } else if (strike == 0 && ball == 0) {
            System.out.println(NOT_THING);
        }
    }

    public void printStartMessage() {
        System.out.println(BASEBALL_GAME_START_MESSAGE);
    }

    public void printEndMessage() {
        System.out.printf((BASEBALL_GAME_END_MESSAGE) + "\n", Constants.GOAL);
    }
}
