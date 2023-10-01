package baseball.controller;

import baseball.converter.TypeConvert;
import baseball.utils.GenerateRandomNumbers;
import baseball.validation.InputValidator;
import baseball.validation.RestartValidator;
import baseball.validation.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    InputView inputView;
    OutputView outputView;

    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame() {
        outputView.printStartMessage();

        Validator inputValidator = new InputValidator();
        Validator restartValidator = new RestartValidator();

        List<Integer> computers = GenerateRandomNumbers.generate();

        boolean finished = false;

        while (!finished) {
            System.out.println("computers = " + computers);
            String number = inputView.inputNumber();

            if (!isValidate(inputValidator, number)) {
                throw new IllegalArgumentException("숫자 입력 오류");
            }

            List<Integer> users = TypeConvert.mapIntegerList(number);
            Score score = new Score(computers, users);

            Integer strike = score.calculateStrike();
            Integer ball = score.calculateBall();

            outputView.printGameScore(strike, ball);

            if (strike == 3) {
                outputView.printEndMessage();
                String restart = inputView.inputRestartOrNot();
                if (!isValidate(restartValidator, restart)) {
                    throw new IllegalArgumentException("재시작 입력 오류");
                }
                if (restart.equals("1")) {
                    computers = GenerateRandomNumbers.generate();
                } else if (restart.equals("2")) {
                    finished = true;
                }
            }
        }
    }


    private Boolean isValidate(Validator validator, String value) {
        return validator.isValidate(value);
    }
}
