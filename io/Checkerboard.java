public class Checkerboard
{
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        boolean isBlue = true;
        for (int j = 0; j < n; j++)
        {
        for (int i = 0; i < n; i++)
            {
                if (isBlue)
                {
                    StdDraw.setPenColor(StdDraw.BLACK);
                }
                else
                {
                    StdDraw.setPenColor(StdDraw.WHITE);
                }
                StdDraw.filledSquare(.5 + i, .5 + j, 0.5);
                isBlue = !isBlue;
            }
            if (n % 2 == 0)
            {
                isBlue = !isBlue;
            }
        }
    }
}