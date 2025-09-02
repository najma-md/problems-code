package problem;

import java.util.Arrays;

public class RestoreFinishingOrder {

    public static void main(String[] args) {
        RestoreFinishingOrder rfo = new RestoreFinishingOrder();
        int[] order = {1,4,5,3,2};
        int[] friends = {2,5};
        int[] result = rfo.recoverOrder(order, friends);
        System.out.println(Arrays.toString(result));
    }

    public int[] recoverOrder(int[] order, int[] friends) {

        int[] ranks = new int[order.length + 1];

        for (int i = 0; i < friends.length; i++) {
            ranks[friends[i]] = 1;
        }

        int frndIndex = 0;
        for (int i = 0; i < order.length; i++) {
            if (ranks[order[i]] == 1) {
                friends[frndIndex] = order[i];
                frndIndex += 1;
            }
        }

        return friends;

    }

}
