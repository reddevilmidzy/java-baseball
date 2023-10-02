package baseball.validation;

import java.util.stream.Collectors;

import static baseball.constant.Constants.MAX_NUMBER;
import static baseball.constant.Constants.MIN_NUMBER;
import static baseball.constant.Constants.NUMBER_SIZE;

public class InputValidator implements Validator {

    @Override
    public Boolean isValidate(String value) {
        if (value == null) return false;
        return isUniqueValue(value) && isNumbers(value) && isValidSize(value);
    }

    private Boolean isUniqueValue(String value) {
        return NUMBER_SIZE == value.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet())
                .size();
    }

    private Boolean isValidSize(String value) {
        return value.length() == NUMBER_SIZE;
    }

    private Boolean isNumbers(String value) {
        return value.chars()
                .allMatch(ch -> Character.isDigit((char) ch) &&
                        (ch - '0' >= MIN_NUMBER && ch - '0' <= MAX_NUMBER));
    }
}
