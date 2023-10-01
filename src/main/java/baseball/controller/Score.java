package baseball.controller;

import java.util.List;
import java.util.stream.IntStream;

public class Score {

    private final List<Integer> computers;
    private final List<Integer> users;

    public Score(List<Integer> computers, List<Integer> users) {
        this.computers = computers;
        this.users = users;
    }

    public Integer calculateStrike() {
        return (int) IntStream.range(0, computers.size())
                .filter(idx -> computers.get(idx).equals(users.get(idx)))
                .count();
    }

    public Integer calculateBall() {
        return (int) IntStream.range(0, computers.size())
                .filter(idx -> computers.contains(users.get(idx)) && !computers.get(idx).equals(users.get(idx)))
                .count();
    }
}
