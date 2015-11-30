package pig;

/**
 * Created by rachel-killackey on 10/29/14.
 */

import java.util.Random;

public class Dice {

    private int dFaceValue;

    public int throwDice() {
        Random ran = new Random();
        int nRand = ran.nextInt(6) + 1;
        dFaceValue = nRand;
        return nRand;
    }

}
