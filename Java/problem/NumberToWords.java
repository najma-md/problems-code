package problem;

public class NumberToWords {

    public static void main(String[] args) {
        int num = 1000;
        String result = numberToWords(num);
        System.out.println("Number in words: " + result);
    }

    public static String numberToWords(int num) {
        if (num < 0) {
            return "Invalid Value";
        }
        // if(num==0) return getDigitWord(num);

        String output = "";
        int noOfDigits = getDigitCount(num);
        while (noOfDigits > 0) {
            int digit = num % 10;
            output = getDigitWord(digit) + " " + output;
            num /= 10;
            noOfDigits -= 1;
        }

        System.out.println(output);

        return output.trim();

    }

    public static int getDigitCount(int num) {
        String numStr = num + "";

        return numStr.length();
    }

    public static String getDigitWord(int num) {
        String val = "";

        switch (num) {
            case 0:
                val = "Zero";
                break;
            case 1:
                val = "One";
                break;
            case 2:
                val = "Two";
                break;
            case 3:
                val = "Three";
                break;
            case 4:
                val = "Four";
                break;
            case 5:
                val = "Five";
                break;
            case 6:
                val = "Six";
                break;
            case 7:
                val = "Seven";
                break;
            case 8:
                val = "Eight";
                break;
            case 9:
                val = "Nine";
                break;

        }

        return val;

    }
}
