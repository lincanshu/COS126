public class ShannonEntropy
{
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int amount = 0;
        int[] count = new int[m + 1];
        double H = 0.0;
        while (!StdIn.isEmpty())
        {
            int x = StdIn.readInt();
            count[x]++;
            amount++;
        }
        for (int i = 1; i <= m; i++)
        {
            if (count[i] == 0) continue;
            H -= (Math.log(count[i] * 1.0 / amount) / Math.log(2)) * count[i] / amount;
        }
        StdOut.printf("%.4f\n", H);
    }
}
