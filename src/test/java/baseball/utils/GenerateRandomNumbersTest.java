package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateRandomNumbersTest {
    @Test
    @DisplayName("서로 다른 3자리 랜덤 숫자 생성 확인")
    void checkUniqueRandomNumbers() {
        GenerateRandomNumbers numbers = new GenerateRandomNumbers();
        Set<Integer> uniqueNumbers = new HashSet<>(numbers.generate());
        assertThat(uniqueNumbers).containsAnyOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .hasSizeGreaterThanOrEqualTo(3);
    }
}