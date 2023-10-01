package baseball.controller;

import baseball.view.InputView;

public class BaseballController {
    InputView inputView;

    public BaseballController(InputView inputView) {
        this.inputView = inputView;
    }

    public void playGame() {
        String number = inputView.inputNumber();

    }
}
