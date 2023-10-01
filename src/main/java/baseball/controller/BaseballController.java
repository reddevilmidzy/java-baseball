package baseball.controller;

import baseball.converter.TypeConvert;
import baseball.utils.GenerateRandomNumbers;
import baseball.validation.InputValidator;
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
        Validator validator = new InputValidator();

        List<Integer> computers = GenerateRandomNumbers.generate();
        System.out.println("computers = " + computers);

        boolean finished = false;

        while (!finished) {
            String number = inputView.inputNumber();

            if (!validator.isValidate(number)) {
                throw new IllegalArgumentException();
            }

            List<Integer> users = TypeConvert.mapIntegerList(number);
            Score score = new Score(computers, users);

            Integer strike = score.calculateStrike();
            Integer ball = score.calculateBall();

            outputView.printGameScore(strike, ball);

            if (strike == 3) {
                finished = true;
                outputView.printEndMessage();
            }
        }

    }
}
