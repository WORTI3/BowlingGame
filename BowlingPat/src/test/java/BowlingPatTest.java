import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingPatTest {

    private BowlingPat game;

    @BeforeEach
    void setup() {
        //given
        game = new BowlingPat();
    }

    @Test
    void gutterGameShouldScoreZero() {
        //when
        roll(0, 20);
        //then
        assertEquals(0, game.getScore());
    }


    @Test
    void singlePinsShouldScoreTen() {
        //when
        roll(1, 20);

        //then
        assertEquals(20, game.getScore());
    }

    @Test
    void spareShouldScoreBonusNextRoll() {
        //when
        game.roll(9);
        game.roll(1);
        roll(1, 9);
        //then - bonus 1 point for spare
        assertEquals(20, game.getScore());
    }

    @Test
    void strikeShouldScoreBonusNextRollAndMissNextFrame(){
        game.roll(10);
        roll(1, 10);
        //then - bonus 1 point for spare
        assertEquals(20, game.getScore());
    }

    @Test
    void score300IfStrikes(){
        roll(10, 20);
        assertEquals(300, game.getScore());
    }

    private void roll(int pins, int times) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }
}