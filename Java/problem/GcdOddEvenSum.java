package problem;

public class GcdOddEvenSum {

    public static void main(String[] args) {
        GcdOddEvenSum solver = new GcdOddEvenSum();
        int n = 10; // Example input
        int result = solver.gcdOfOddEvenSums(n);
        System.out.println("Result: " + result);
    }

    public int gcdOfOddEvenSums(int n) {
        return (n * (n + 1)) - (n * n);
    }

}
