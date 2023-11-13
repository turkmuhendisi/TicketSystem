package controller.mail;

import java.util.Random;

public class RandomDigitGenerator {
    private int authCode;

    public RandomDigitGenerator() {
    }

    public int digitGenerator() {
        Random random = new Random();
        int min = 100000;
        int max = 999999;
        authCode = random.nextInt(max - min + 1) + min;
        // Output Test
        //System.out.println(authCode);
        return authCode;
    }
}
