package baseball.controller;

import baseball.converter.TypeConvert;
import baseball.service.Score;
import baseball.utils.GenerateRandomNumbers;
import baseball.validation.InputValidator;
import baseball.validation.RestartValidator;
import baseball.validation.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static baseball.constant.Constants.GOAL;
import static baseball.constant.Constants.RESTART;

public class BaseballController {
    InputView inputView;
    OutputView outputView;

    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        playGame();
    }

    private void playGame() {

        Validator inputValidator = new InputValidator();
        List<Integer> computers = GenerateRandomNumbers.generate();

        while (true) {
            System.out.println("computers = " + computers);
            String number = inputView.inputNumber();
            if (!isValidate(inputValidator, number)) {
                throw new IllegalArgumentException("숫자 입력 오류");
            }
            List<Integer> users = TypeConvert.mapIntegerList(number);
            Integer strike = calculateResult(new Score(computers, users));
            if (strike == GOAL && !isRestart()) {
                return;
            } else if (strike == GOAL) {
                break;
            }
        }
        playGame();
    }

    private Integer calculateResult(Score score) {
        Integer strike = score.calculateStrike();
        Integer ball = score.calculateBall();
        outputView.printGameScore(strike, ball);
        return strike;
    }

    private Boolean isRestart() {
        outputView.printEndMessage();
        String result = inputView.inputRestartOrNot();
        if (!isValidate(new RestartValidator(), result)) {
            throw new IllegalArgumentException("재시작 입력 오류");
        }
        return result.equals(RESTART);
    }

    private Boolean isValidate(Validator validator, String value) {
        return validator.isValidate(value);
    }
}
