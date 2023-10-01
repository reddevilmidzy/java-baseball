package baseball.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TypeConvertTest {

    @Test
    @DisplayName("문자열 분리 후 숫자 리스트로 반환")
    void checkValue() {
        assertThat(TypeConvert.mapIntegerList("123")).isEqualTo(List.of(1,2,3));
        assertThat(TypeConvert.mapIntegerList("928")).isEqualTo(List.of(9,2,8));
        assertThat(TypeConvert.mapIntegerList("562")).isEqualTo(List.of(5,6,2));
    }
}