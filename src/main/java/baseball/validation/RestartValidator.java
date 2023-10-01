package baseball.validation;

import java.util.Objects;

import static baseball.constant.Constants.RESTART;
import static baseball.constant.Constants.STOP;

public class RestartValidator implements Validator {

    @Override
    public Boolean isValidate(String value) {
        return Objects.equals(value, RESTART) || Objects.equals(value, STOP);
    }
}
