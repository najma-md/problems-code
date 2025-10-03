package problem;

public class NumberComplement {

    public static void main(String[] args) {
        NumberComplement solver = new NumberComplement();
        int num = 8;
        int result = solver.findComplement(num);
        System.out.println("Number complement: " + result);
    }

    public int findComplement(int num) {

        int digit = 0;
        int place = 0;
        int output = 0;
        while (num > 0) {
            digit = num % 2;
            output += (1 - digit) == 0 ? 0 : Math.pow(2, place);
            place += 1;
            num /= 2;

        }

        return output;
    }

}
