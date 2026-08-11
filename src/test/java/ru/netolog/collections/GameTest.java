package ru.netolog.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenFirstPlayerNotRegistered() {
        Player kolya = new Player(1, "Коля", 100);
        Game game = new Game();

        game.register(kolya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Дима", "Коля")
        );
    }

    @Test
    public void testWhenSecondPlayerNotRegistered() {
        Player kolya = new Player(1, "Коля", 100);
        Game game = new Game();

        game.register(kolya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Коля", "Дима")
        );
    }

    @Test
    public void testWhenFirstPlayerWin() {
        Player kolya = new Player(1, "Коля", 100);
        Player dima = new Player(2, "Дима", 90);
        Game game = new Game();

        game.register(kolya);
        game.register(dima);
        int actual = game.round("Коля", "Дима");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player kolya = new Player(1, "Коля", 100);
        Player dima = new Player(2, "Дима", 120);
        Game game = new Game();

        game.register(kolya);
        game.register(dima);
        int actual = game.round("Коля", "Дима");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenStrengthsEqual() {
        Player kolya = new Player(1, "Коля", 100);
        Player dima = new Player(2, "Дима", 100);
        Game game = new Game();

        game.register(kolya);
        game.register(dima);
        int actual = game.round("Коля", "Дима");
        int expected = 0;

        Assertions.assertEquals(expected, actual);


    }
}
