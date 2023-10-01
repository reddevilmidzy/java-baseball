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
    @DisplayName("자리는 다르고 숫자만 같은 경우 - 볼")
    void calculateBallTest() {
        assertThat(new Score(List.of(1,2,3), List.of(1,2,3)).calculateBall()).isEqualTo(0);
        assertThat(new Score(List.of(5,6,7), List.of(1,5,7)).calculateBall()).isEqualTo(1);
        assertThat(new Score(List.of(4,5,6), List.of(5,4,9)).calculateBall()).isEqualTo(2);
        assertThat(new Score(List.of(7,8,9), List.of(8,9,7)).calculateBall()).isEqualTo(3);
    }

    @Test
    void calculateBall() {
    }
}