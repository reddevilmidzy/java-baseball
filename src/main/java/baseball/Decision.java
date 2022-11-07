package baseball;

import java.util.HashMap;

import static baseball.Constant.*;

public class Decision {

    public static boolean out = false;
    public static boolean playing = true;

    public static void call() {
        HashMap<String, Integer> result = Score.total();
        if (result.get(STRIKE) == 3) {
            PrintMessage.onlyStrikeCount();
            out();
            return;
        }
        if (result.get(STRIKE) != 0 && result.get(BALL) != 0) {
            PrintMessage.ballAndStrikeCount();
            return;
        }

        if (result.get(STRIKE) == 0 && result.get(BALL) != 0) {
            PrintMessage.onlyBallCount();
            return;
        }
        if (result.get(STRIKE) != 0 && result.get(BALL) == 0) {
            PrintMessage.onlyStrikeCount();
            return;
        }
        PrintMessage.notThing();
    }


    public static void out() {
        PrintMessage.gameEnd();
        out = true;
    }

    public static void reStart() {
        playing = true;
        out = false;
    }

    public static void quitGame() {
        playing = false;
    }
}
