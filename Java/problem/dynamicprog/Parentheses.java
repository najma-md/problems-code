package problem.dynamicprog;

import java.util.ArrayList;
import java.util.List;

public class Parentheses {

    public static void main(String[] args) {
        Parentheses p = new Parentheses();
        System.err.println(p.diffWaysToCompute("2*3-4*5"));
    }

    public List<Integer> navigate(String expression) {
        char currChar = 0;
        List<Integer> output = new ArrayList<Integer>();

        for (int i = 0; i < expression.length(); i++) {
            List<Integer> left = new ArrayList<Integer>();
            List<Integer> right = new ArrayList<Integer>();

            currChar = expression.charAt(i);
            if (currChar == '+' || currChar == '-' || currChar == '*') {
                left = navigate(expression.substring(0, i));
                right = navigate(expression.substring(i + 1));
            }

            for (int l : left) {
                for (int r : right) {
                    output.add(calculate(currChar, l, r));
                }
            }

        }

        if (output.isEmpty()) {
            output.add(Integer.parseInt(expression));
        }
        return output;
    }

    public int calculate(int operator, int l, int r) {
        int val = 0;
        if (operator == '+') {
            val = (l + r);
        }
        if (operator == '-') {
            val = (l - r);
        }
        if (operator == '*') {
            val = (l * r);
        }
        return val;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return navigate(expression);
    }

}
