package baseball.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputValidatorTest {
    Validator inputValidator = new InputValidator();

    @Test
    @DisplayName("올바른 사용자 입력인지 확인")
    void checkValidValue() {
        assertThat(inputValidator.isValidate("123")).isTrue();
        assertThat(inputValidator.isValidate("948")).isTrue();
        assertThat(inputValidator.isValidate("765")).isTrue();
    }

    @Test
    @DisplayName("잘못된 사용자 입력 확인")
    void checkInvalidValue() {
        assertThat(inputValidator.isValidate("012")).isFalse();
        assertThat(inputValidator.isValidate("989")).isFalse();
        assertThat(inputValidator.isValidate("87")).isFalse();
        assertThat(inputValidator.isValidate("1223")).isFalse();
        assertThat(inputValidator.isValidate("1235")).isFalse();
        assertThat(inputValidator.isValidate("red")).isFalse();
        assertThat(inputValidator.isValidate("")).isFalse();
        assertThat(inputValidator.isValidate(null)).isFalse();
    }
}