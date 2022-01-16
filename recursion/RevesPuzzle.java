/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RevesPuzzle {

    private static void hanoi(int n, int count, char from, char temp, char to)
    {
        if (count == 0)
        {
            return;
        }
        hanoi(n - 1, count - 1, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, count - 1, temp, from, to);
    }

    private static void reve(int n, char from, char pole1, char to, char pole2)
    {
        if (n == 0)
        {
            return;
        }

        // let k denote the integer nearest to this
        int k = (int)Math.round(n + 1 - Math.sqrt(2*n + 1));
        // Transfer (recursively) the k smallest discs to a single pole other than the start or toination poles.
        reve(k, from, to, pole1, pole2);

        // Transfer the remaining n−k disks to the toination pole (without
        // using the pole that now contains the smallest k discs).
        // To do so, use the algorithm for the 3-pole towers of Hanoi problem.
        hanoi(n, n-k, from, pole2, to);

        // Transfer (recursively) the k smallest discs to the toination pole.
        reve(k, pole1, from, to, pole2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reve(n, 'A', 'B', 'D', 'C');
    }
}
