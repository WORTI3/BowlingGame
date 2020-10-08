public class BowlingPat {

    private final static int MAX_PINS_PER_FRAME = 10;
    private final static int MAX_FRAMES_PER_GAME = 10;
    private final static int MAX_BOWLS_PER_GAME = 21;

    private int rollCounter = 0;
    private final int[] rolls = new int[MAX_BOWLS_PER_GAME];

    public void roll(int pins){ // takes the number of pins per roll
        rolls[rollCounter++] = pins; // assigns the number of pins per roll to rolls foreach roll 0-21
    }

    public int getScore(){
        // Start of a game all these should be 0
        int score = 0; // Overall score 0-300
        int bowls = 0; // The number of bowls a game is on out of 21 indexing between the array
        int frame = 0; // Local frame that a game is on up to 10

        // counts up through variables until frames or bowls limit is reached
        while(frame < MAX_FRAMES_PER_GAME) { // Ten is max amount of frames foreach frame until 10 is reached
            if(rolls[bowls] == MAX_PINS_PER_FRAME){ // Strike if a single frame is equal to ten
                score += MAX_PINS_PER_FRAME + rolls[bowls + 1] + rolls[bowls + 2];
                bowls++;
            }else if (rolls[bowls] + rolls[bowls + 1] == MAX_PINS_PER_FRAME) { // Should check for a Spare
                score += MAX_PINS_PER_FRAME + rolls[bowls + 2]; // increments score by 10 plus whatever next frame equals
                bowls += 2;
            } else { // If no spare
                score += rolls[bowls] + rolls[bowls + 1]; // increment score by bowls value each frame has 2 parts to it.
                bowls += 2; // continue through bowls
            }
            frame++; // Continue through frames
        }

        return score; // returns int: score
    }
}