public class Birthday
{
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int[] count = new int[n + 2];
        boolean[] flag = new boolean[n];
        for (int t = 0; t < trials; t++)
        {
            for (int i = 0; i < n; i++)
            {
                flag[i] = false;
            }
            int people = 0;
            while (true)
            {
                people++;
                int date = (int)(Math.random() * n);
                if (flag[date])
                {
                    break;
                }
                flag[date] = true;
            }
            count[people]++;
        }
        double fraction = 0.0;
        for (int i = 1, sum = 0; fraction < 0.5; i++)
        {
            sum += count[i];
            fraction = 1.0 * sum / trials;
            System.out.println(i + "\t" + count[i] + "\t" + fraction);
        }
    }
}