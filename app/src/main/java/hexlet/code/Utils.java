package hexlet.code;

public final class Utils {
    public static int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static int getRandomIntInclusive(int min, int max) {
        return getRandomInt(min, max + 1);
    }
}
