package baseball.validation;

import java.util.Objects;

public class RestartValidator implements Validator {

    public static final String RESTART = "1";
    public static final String STOP = "2";

    @Override
    public Boolean isValidate(String value) {
        return Objects.equals(value, RESTART) || Objects.equals(value, STOP);
    }
}
