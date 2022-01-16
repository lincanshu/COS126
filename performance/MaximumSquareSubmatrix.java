/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int n = a.length;
        int[][] aux = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aux[i][j] = a[i][j];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                // here is the key
                if (aux[i][j] == 1) {
                    int min = Math.min(aux[i-1][j], aux[i][j-1]);
                    min = Math.min(min, aux[i-1][j-1]) + 1;
                    aux[i][j] = Math.max(aux[i][j], min);
                }
           }
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                ans = Math.max(ans, aux[i][j]);
            }
        }
        return ans;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        int ans = size(a);
        StdOut.println(ans);
    }
}
