package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        PrintMessage.gameStart();
        GameSystem gameSystem = new GameSystem();
        gameSystem.startGame();
    }
}