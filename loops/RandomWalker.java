public class RandomWalker
{
    public static void main(String[] args)
    {
        int step = 0;
        int r = Integer.parseInt(args[0]);
        int x = 0, y = 0;
        System.out.printf("(%d, %d)\n", x, y);
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
            System.out.printf("(%d, %d)\n", x, y);
            step++;
        }
        System.out.println("steps = " + step);
    }
}