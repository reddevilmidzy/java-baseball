package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;

import static baseball.Constant.*;

public class UserInput {
    private String input;
    private List<Integer> numbers;
    private String reStartOrQuitInput;

    public void putNumbers(List<Integer> numbers) {
        Score score = new Score();
        score.userNumbers(numbers);
    }

    public void inputNumbers() { // 추후에 이름 변경 필요 numbers
        PrintMessage.enterNumber();
        this.input = Console.readLine();
        isValid();
        convertNumbers();
        putNumbers(numbers);
    }

    public String chooseReStartOrQuit() {
        PrintMessage.chooseRestartOrQuitGame();
        this.reStartOrQuitInput = Console.readLine();
        isValidRestartOrQuitGame();

        return this.reStartOrQuitInput;
    }

    private void convertNumbers() {
        Convert convert = new Convert();
        this.numbers = convert.IntegerList(input);
    }

    public void isValid() {
        if (!(isValidGuessNumber() && isValidLength())) {
            throw new IllegalArgumentException("3자리의 서로 다른 수를 입력하셔야 합니다.");
        }
    }

    public void isValidRestartOrQuitGame() {
        if (!(isValidReStartMessage() || isValidQuitGameMessage())) {
            throw new IllegalArgumentException("새로운 게임을 원하시면 1, 게임 종료를 원하시면 2를 입력해주세요");
        }
    }

    private boolean isValidLength() {
        return input.length() == NUMBERS_LENGTH;
    }

    private boolean isValidReStartMessage() {
        return this.reStartOrQuitInput.equals(RE_START_INPUT);
    }

    private boolean isValidQuitGameMessage() {
        return this.reStartOrQuitInput.equals(QUIT_GAME_INPUT);
    }

    private boolean isValidGuessNumber() {
        HashSet<String> setRange1To9 = setRange1To9();
        HashSet<String> inputSet = stringToSet();
        inputSet.retainAll(setRange1To9);
        return inputSet.size() == NUMBERS_LENGTH;
    }

    private HashSet<String> setRange1To9() {
        HashSet<String> setRange1To9 = new HashSet<>();
        for (int i = MIN_RANGE_NUMBER; i <= MAX_RANGE_NUMBER; i++) {
            setRange1To9.add(String.valueOf(i));
        }
        return setRange1To9;
    }

    private HashSet<String> stringToSet() {
        HashSet<String> inputSet = new HashSet<>();
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            inputSet.add(String.valueOf(input.charAt(i)));
        }
        return inputSet;
    }
}
