package problem;

public class RelativeRanks {

    public static void main(String[] args) {
        RelativeRanks solver = new RelativeRanks();
        int[] score = {5, 4, 3, 2, 1};
        String[] result = solver.findRelativeRanks(score);
        System.out.print("Relative ranks: ");
        for (String rank : result) {
            System.out.print(rank + " ");
        }
    }

    public String[] findRelativeRanks(int[] score) {
        int maxScore = 0;
        String[] output = new String[score.length];
        for (int i : score) {
            maxScore = Math.max(maxScore, i);
        }

        int[] rankOrder = new int[maxScore + 1];

        for (int i = 0; i < score.length; i++) {
            rankOrder[score[i]] = i + 1;
        }

        int rank = 1;

        for (int i = rankOrder.length - 1; i >= 0; i--) {
            if (rankOrder[i] > 0) {
                switch (rank) {
                    case 1:
                        output[rankOrder[i] - 1] = "Gold Medal";
                        break;
                    case 2:
                        output[rankOrder[i] - 1] = "Silver Medal";
                        break;
                    case 3:
                        output[rankOrder[i] - 1] = "Bronze Medal";
                        break;
                    default:
                        output[rankOrder[i] - 1] = rank + "";
                        break;
                };

                rank += 1;
            }
        }

        return output;
    }

}
