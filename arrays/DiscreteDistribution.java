public class DiscreteDistribution
{
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            a[i] = Integer.parseInt(args[i]);
        }
        int Sn = 0;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            s[i] = s[i - 1] + a[i];
            Sn += a[i];
        }
        while((m--) > 0)
        {
            int r = (int) (Math.random() * Sn);
            for (int i = 1; i <= n; i++)
            {
                if (r < s[i])
                {
                    System.out.print(i + " ");
                    break;
                }
            }
        }
    }
}