package baseball.view;

public class OutputView {

    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOT_THING = "낫싱";

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
}
