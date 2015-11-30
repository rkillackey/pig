package pig;

/**
 * Created by rachel-killackey on 10/29/14.
 */

public class Computer implements Playable {

    private int score;
    private String name;

    public Computer() {
        this.name = "Computer";
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int s) {
        if (s==0) {
            this.score = 0;
        }
        this.score += s;
    }

}
