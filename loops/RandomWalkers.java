public class RandomWalkers
{
    public static void main(String[] args)
    {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int sum = 0;
        for (int i = 0; i < trials; i++)
        {
            int x = 0, y = 0, step = 0;
            while (Math.abs(x) + Math.abs(y) < r)
            {
                double random = Math.random();
                // north
                if (random < .25)
                {
                    y++;
                }
                // east
                else if (random < .5)
                {
                    x++;
                }
                // south
                else if (random < .75)
                {
                    y--;
                }
                // west
                else
                {
                    x--;
                }
                step++;
            }
            sum += step;
        }
        System.out.println("average number of steps = " + 1.0 * sum / trials);
    }
}