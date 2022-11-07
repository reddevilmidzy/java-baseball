package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static baseball.ConstValue.*;

public class Score {
    private static List<Integer> userNumbers;
    private static List<Integer> computerNumbers;
    public void userNumbers(List<Integer> users) {
        userNumbers = users;
    }

    public void computerNumbers(List<Integer> computers) {
        System.out.println("이번에 뽑은 숫자는: " + computers.get(0) + ": " + computers.get(1) + ": " + computers.get(2));
        computerNumbers = computers;
    }

    public static HashMap<String, Integer> total() {
        HashMap<String, Integer> totalScore = new HashMap<>();
        totalScore.put(STRIKE, getStrike());
        totalScore.put(BALL, getBall());
        return totalScore;
    }

    private static Integer getStrike() {
        int strike = 0;
        for (int index = 0; index < NUMBERS_LENGTH; index++) {
            if (isStrike(index)) {
                strike += 1;
            }
        }
        return strike;
    }

    private static Integer getBall() {
        int ball = 0;
        for (int index = 0; index < NUMBERS_LENGTH; index++) {
            if (isBall(index) && !isStrike(index)) {
                ball += 1;
            }
        }
        return ball;
    }

    private static boolean isStrike(int index) {
        return Objects.equals(computerNumbers.get(index), userNumbers.get(index));
    }

    private static boolean isBall(int index) {
        return computerNumbers.contains(userNumbers.get(index));
    }
}
