package baseball.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {

    @Test
    @DisplayName("자리와 숫자 모두 같은 경우 - 스트라이크")
    void calculateStrikeTest() {
        assertThat(new Score(List.of(4, 3, 1), List.of(8, 5, 7)).calculateStrike()).isEqualTo(0);
        assertThat(new Score(List.of(1, 2, 3), List.of(6, 2, 7)).calculateStrike()).isEqualTo(1);
        assertThat(new Score(List.of(6, 9, 3), List.of(6, 9, 7)).calculateStrike()).isEqualTo(2);
        assertThat(new Score(List.of(8, 5, 7), List.of(8, 5, 7)).calculateStrike()).isEqualTo(3);
    }

    @Test
    void calculateBall() {
    }
}