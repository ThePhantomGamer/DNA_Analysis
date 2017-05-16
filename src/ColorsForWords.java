/**
 * Created by fredkneeland on 5/3/17.
 */
public class ColorsForWords {
    public int[][] getColorsForWords(String dna) {
        int dnaLength = dna.length();
        int[][] colors = new int[dnaLength][3];

        // find all short words r -> value
        DNA_word_finder finder = new DNA_word_finder(dna, 3);

        finder.getSizes2();
        int[] minNMax = finder.getMinAndMax();
        double min = minNMax[0];
        double max = minNMax[1];

        System.out.println("small");
        System.out.println("min: " + min);
        System.out.println("max"  + max);

        for (int i = 0; i < dnaLength; i++) {
            int val = finder.getMaxWordCount(i);
            val = (int) (((val) / max) * 250);

            System.out.println("value: " + val);
            colors[i][0] = val;
        }


        // find all medium words b -> value
        finder = new DNA_word_finder(dna, 5);

        finder.getSizes2();
        minNMax = finder.getMinAndMax();
        min = minNMax[0];
        max = minNMax[1];

        System.out.println("medium");
        System.out.println("min: " + min);
        System.out.println("max"  + max);

        for (int i = 0; i < dnaLength; i++) {
            int val = finder.getMaxWordCount(i);
            colors[i][1] = (int) (((val - min) / max) * 250);
        }

        System.out.println("done with medium");

        // find all long words g -> value
        finder = new DNA_word_finder(dna, 8);

        finder.getSizes2();
        minNMax = finder.getMinAndMax();
        min = minNMax[0];
        max = minNMax[1];

        System.out.println("large");
        System.out.println("min: " + min);
        System.out.println("max"  + max);

        for (int i = 0; i < dnaLength; i++) {
            int val = finder.getMaxWordCount(i);
            colors[i][2] = (int) (((val - min) / max) * 250);
        }

        System.out.println("values: " + colors[dnaLength-1][0] + ", " + colors[dnaLength-1][1] + ", " + colors[dnaLength-1][2]);

        return colors;
    }

    public int[][] getColorsFromFinders(DNA_word_finder finder1, DNA_word_finder finder2, DNA_word_finder finder3, String dna, int min1, int max1, int min2, int max2, int min3, int max3) {
        int dnaLength = dna.length();
        int[][] colors = new int[dnaLength][3];

        // find all short words r -> value
        finder1.getSizes2();
        double min = min1;
        double max = max1;

        for (int i = 0; i < dnaLength; i++) {
            int val = finder1.getMaxWordCount(i);
            colors[i][0] = (int) (((val - min) / (max - min)) * 250);
        }


        // find all medium words b -> value
        finder2.getSizes2();
        min = min2;
        max = max2;

        for (int i = 0; i < dnaLength; i++) {
            int val = finder2.getMaxWordCount(i);
            colors[i][1] = (int) (((val - min) / (max - min)) * 250);
        }

        // find all long words g -> value
        finder3.getSizes2();
        min = min3;
        max = max3;

        for (int i = 0; i < dnaLength; i++) {
            int val = finder3.getMaxWordCount(i);
            colors[i][2] = (int) (((val - min) / (max - min)) * 250);
        }

        return colors;
    }

    public int[][] getAbsoluteColorsForDNA(String dna, int min1, int max1, int min2, int max2, int min3, int max3) {
        int dnaLength = dna.length();
        int[][] colors = new int[dnaLength][3];

        // find all short words r -> value
        DNA_word_finder finder = new DNA_word_finder(dna, 3);

        finder.getSizes2();
        double min = min1;
        double max = max1;

        for (int i = 0; i < dnaLength; i++) {
            int val = finder.getMaxWordCount(i);
            colors[i][0] = (int) (((val - min) / max) * 250);
        }


        // find all medium words b -> value
        finder = new DNA_word_finder(dna, 5);

        finder.getSizes2();
        min = min2;
        max = max2;

        for (int i = 0; i < dnaLength; i++) {
            int val = finder.getMaxWordCount(i);
            colors[i][1] = (int) (((val - min) / max) * 250);
        }

        // find all long words g -> value
        finder = new DNA_word_finder(dna, 8);

        finder.getSizes2();
        min = min3;
        max = max3;

        for (int i = 0; i < dnaLength; i++) {
            int val = finder.getMaxWordCount(i);
            colors[i][2] = (int) (((val - min) / max) * 250);
        }

        return colors;
    }
}
