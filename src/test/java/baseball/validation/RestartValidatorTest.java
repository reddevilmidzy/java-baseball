package baseball.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RestartValidatorTest {
    Validator restartValidator = new RestartValidator();

    @Test
    @DisplayName("올바른 재시작 / 종료 입력 확인")
    void checkValidValue() {
        assertThat(restartValidator.isValidate("1")).isTrue();
        assertThat(restartValidator.isValidate("2")).isTrue();
    }

    @Test
    @DisplayName("잘못된 재시작 / 종료 입력 확인")
    void checkInvalidValue() {
        assertThat(restartValidator.isValidate(null)).isFalse();
        assertThat(restartValidator.isValidate("")).isFalse();
        assertThat(restartValidator.isValidate("3")).isFalse();
        assertThat(restartValidator.isValidate("123")).isFalse();
        assertThat(restartValidator.isValidate("21")).isFalse();
    }

}