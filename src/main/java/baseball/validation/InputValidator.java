package baseball.validation;

import java.util.stream.Collectors;

import static baseball.constant.Constants.NUMBER_SIZE;
import static baseball.constant.Constants.MAX_NUMBER;
import static baseball.constant.Constants.MIN_NUMBER;

public class InputValidator implements Validator {

    @Override
    public Boolean isValidate(String value) {
        if (value == null) return false;
        return isUniqueValue(value) && isNumbers(value);
    }

    private Boolean isUniqueValue(String value) {
        return NUMBER_SIZE == value.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet())
                .size();
    }

    private Boolean isNumbers(String value) {
        return value.chars()
                .allMatch(ch -> Character.isDigit((char) ch) &&
                (ch - '0' >= MIN_NUMBER && ch - '0' <= MAX_NUMBER));
    }
}
