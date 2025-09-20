package problem;

public class GenerateTagProb {

    public static void main(String[] args) {
        GenerateTagProb solver = new GenerateTagProb();
        String caption = "Hello world This is a sample caption for generating a tag";
        String result = solver.generateTag(caption);
        System.out.println("Generated Tag: " + result);
    }

    public String generateTag(String caption) {
        StringBuilder output = new StringBuilder();
        output.append("#");

        String[] words = caption.trim().split("\\s");
        if (words.length == 0) {
            return output.toString();
        }

        output.append(words[0].toLowerCase());

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > 0) {
                output.append(words[i].substring(0, 1).toUpperCase());
                output.append(words[i].substring(1).toLowerCase());
            }

        }

        String returnOut = output.toString();
        return returnOut.length() > 100 ? returnOut.substring(0, 100) : returnOut;

    }

    public String generateTag_2(String caption) {
        StringBuilder output = new StringBuilder();
        output.append("#");
        boolean isFirst = true;
        String[] words = caption.split("\\s");

        for (String str : words) {
            if (str.matches("^[a-zA-Z]+$")) {
                if (isFirst) {
                    output.append(str.toLowerCase());
                    isFirst = false;
                } else {
                    output.append(str.substring(0, 1).toUpperCase());
                    output.append(str.substring(1).toLowerCase());
                }
            }

        }

        String returnOut = output.toString();
        return returnOut.length() > 100 ? returnOut.substring(0, 100) : returnOut;

    }
}
