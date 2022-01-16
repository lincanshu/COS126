/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int i = 0, j = n - 1;
        int[] p = new int[n];
        for (int idx = 0; idx < n; idx++)
        {
            if (k >= (j - i))
            {
                k -= j;
                p[idx] = j--;
            }
            else
            {
                p[idx] = i++;
            }
        }
        return p;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] p = generate(n, k);
        for (int i : p) {
            StdOut.print(i + " ");
        }
    }
}