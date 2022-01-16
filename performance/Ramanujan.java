/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int count = 0;
        long n_cbrt = (long)Math.cbrt(n);
        for (long i = 1; i <= n_cbrt; i++) {
            double j = Math.cbrt(n - i * i * i);
            if (Math.abs(j - Math.round(j)) < Double.MIN_VALUE) {
                count++;
            }
        }
        return count >= 4;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}