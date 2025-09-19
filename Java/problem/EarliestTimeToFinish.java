package problem;

public class EarliestTimeToFinish {   
    
    public static void main(String[] args) {
        EarliestTimeToFinish solver = new EarliestTimeToFinish();
        int[][] tasks = {
            {2, 5},
            {1, 3},
            {4, 2}
        };
        int result = solver.earliestTime(tasks);
        System.out.println("Earliest time to finish: " + result);
    }

    public int earliestTime(int[][] tasks) {

        if (tasks.length <= 0) {
            return 0;
        }

        int earliestTime = Integer.MAX_VALUE;

        for (int i = 0; i < tasks.length; i++) {
            earliestTime = Math.min(earliestTime, tasks[i][0] + tasks[i][1]);
        }

        return earliestTime;
    }

}
