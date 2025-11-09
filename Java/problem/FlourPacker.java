package problem;

public class FlourPacker {

    public static void main(String[] args) {
        int bigCount = 2;
        int smallCount = 2;
        int goal = 11;
        boolean result = canPack(bigCount, smallCount, goal);
        System.out.println("Can pack flour: " + result);
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        int bigbagsrequired = Math.min(bigCount, goal / 5);
        int remaining = goal - (bigbagsrequired * 5);

        return remaining <= smallCount;
    }

}
