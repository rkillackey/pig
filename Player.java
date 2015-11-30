package pig;

/**
 * Created by rachel-killackey on 10/29/14.
 */

public class Player implements Playable {

    private String name;
    private int score;

    public Player() {
        this.name = "";
        this.score = 0;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return this.name;
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
