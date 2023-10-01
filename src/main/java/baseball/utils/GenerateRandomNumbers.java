package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.Constants.NUMBER_SIZE;
import static baseball.constant.Constants.MAX_NUMBER;
import static baseball.constant.Constants.MIN_NUMBER;

public class GenerateRandomNumbers {

    public GenerateRandomNumbers() {
    }

    public static List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
