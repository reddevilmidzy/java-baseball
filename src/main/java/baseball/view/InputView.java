package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    //TODO: 시작 1과 종료 2는 언제든지 바뀔 수 있다. 메시지와 숫자를 분리하자.
    public static final String RESTART_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String inputNumber() {
        System.out.print(NUMBER_INPUT_MESSAGE);
        return readInput();
    }

    public String inputRestartOrNot() {
        System.out.println(RESTART_INPUT_MESSAGE);
        return readInput();
    }

    protected String readInput() {
        return Console.readLine();
    }
}
