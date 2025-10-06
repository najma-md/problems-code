package problem;

public class ConstructRectangle {

    public static void main(String[] args) {
        ConstructRectangle solver = new ConstructRectangle();
        int area = 4;
        int[] result = solver.constructRectangle(area);
        System.out.println("Constructed rectangle: [" + result[0] + ", " + result[1] + "]");
    }

    public int[] constructRectangle(int area) {

        int uL = (int) Math.sqrt(area);
        int[] output = new int[2];

        if (area == 0) {
            return output;
        }

        for (int i = uL; i > 0; i--) {

            if (area % i == 0) {
                int div = area / i;
                output[0] = div;
                output[1] = i;
                return output;
            }

        }
        return output;
    }

}
