package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public String inputNumber() {
        System.out.print(NUMBER_INPUT_MESSAGE);
        return readInput();
    }

    protected String readInput() {
        return Console.readLine();
    }
}
