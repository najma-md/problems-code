package problem;

public class TeemoAttacking {

    public static void main(String[] args) {
        TeemoAttacking solver = new TeemoAttacking();
        int[] timeSeries = {1, 4};
        int duration = 2;
        int result = solver.findPoisonedDuration(timeSeries, duration);
        System.out.println("Total poisoned duration: " + result);
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int output = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i] + duration - 1 < timeSeries[i + 1]) {
                output += duration;
            } else {
                output += timeSeries[i + 1] - timeSeries[i];
            }
        }

        return output += duration;
    }
}
