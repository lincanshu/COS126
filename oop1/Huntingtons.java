/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int max = 0;
        for (int i = 0; i < dna.length() - 2; i++) {
            int count = 0;
            while (dna.startsWith("CAG", i)) {
                count++;
                i += 3;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        s = s.replace(" ", "");
        s = s.replace("\n", "");
        s = s.replace("\t", "");
        return s;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10) {
            return "not human";
        }
        else if (maxRepeats < 36) {
            return "normal";
        }
        else if (maxRepeats < 40) {
            return "high risk";
        }
        else if (maxRepeats < 181) {
            return "Huntington's";
        }
        else {
            return "not human";
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {
        In in = new In(args[0]);
        String dna = removeWhitespace(in.readAll());
        int maxRepeats = maxRepeats(dna);
        StdOut.println("max repeats = " + maxRepeats);
        StdOut.println(diagnose(maxRepeats));
    }

}
