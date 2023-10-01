package baseball.converter;

import java.util.List;
import java.util.stream.Collectors;

public class TypeConvert {
    public static List<Integer> mapIntegerList(String value) {
        return value.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }
}
