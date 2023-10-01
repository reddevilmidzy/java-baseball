package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.constant.Constants.RESTART;
import static baseball.constant.Constants.STOP;

public class InputView {

    public static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String RESTART_INPUT_MESSAGE = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.";

    public InputView() {
    }

    public String inputNumber() {
        System.out.print(NUMBER_INPUT_MESSAGE);
        return readInput();
    }

    public String inputRestartOrNot() {
        System.out.printf((RESTART_INPUT_MESSAGE) + "%n", RESTART, STOP);
        return readInput();
    }

    protected String readInput() {
        return Console.readLine();
    }
}
