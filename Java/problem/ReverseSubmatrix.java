package problem;

import java.util.Arrays;

public class ReverseSubmatrix {

    public static void main(String[] args) {
        ReverseSubmatrix rsm = new ReverseSubmatrix();
        int[][] grid = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int x = 1, y = 0, k = 3;
        int[][] result = rsm.reverseSubmatrix(grid, x, y, k);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

     public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
    
        for(int j=y;j<y+k;j++)
        {
            int last=x+k-1;
            for(int top=x;top<x+k-1 && top<last;top++)
            {
                int temp=grid[top][j];
                grid[top][j]=grid[last][j];
                grid[last][j]=temp;
                last-=1;
            }
        } 
        return grid;      
    }
    
}
