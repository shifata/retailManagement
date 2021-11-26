package Utils;

import java.util.Random;

public class IdGenerator {

    public static String getId(int n) {
        String id = "";
        Random random = new Random();
        int randomMax = 9;

        for (int i = 0; i < n; i++) {
            id += random.nextInt(randomMax) + "";
        }

        return id;
    }
}
