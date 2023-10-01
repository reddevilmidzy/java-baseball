package baseball.validation;

import java.util.stream.Collectors;

public class InputValidator implements Validator {

    public static final int GUESS_NUMBER_SIZE = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    @Override
    public Boolean isValidate(String value) {
        return isUniqueValue(value) && isNumbers(value);
    }

    private Boolean isUniqueValue(String value) {
        return value.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet())
                .size() == GUESS_NUMBER_SIZE;
    }

    private Boolean isNumbers(String value) {
        return value.chars()
                .allMatch(ch -> Character.isDigit((char) ch) &&
                (ch - '0' >= MIN_NUMBER && ch - '0' <= MAX_NUMBER));
    }
}
