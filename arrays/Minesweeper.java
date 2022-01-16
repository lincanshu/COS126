public class Minesweeper
{
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        // if (x, y) boom
        boolean[][] mines = new boolean[m][n]; // m * n

        // random the booms
        int total = m * n;
        int[] array = new int[total];
        for (int i = 0; i < total; i++)
        {
            array[i] = i;
        }
        for (int i = 0; i < k; i++)
        {
            int r = i + (int)(Math.random() * (total - i)); 
            int t = array[i];
            array[i] = array[r];
            array[r] = t;
        }
        // the first k index is the location of boom
        for (int i = 0; i < k; i++)
        {
            mines[array[i] / n][array[i] % n] = true;
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
            	// (x, y) boom
                if (mines[i][j])
                {
                    System.out.print("*  ");
                }
                else
                {
                    int count = 0;
                    // control the range
                    if (i - 1 >= 0 && j - 1 >= 0 && mines[i - 1][j - 1]) count++;
                    if (i + 1 < m  && j - 1 >= 0 && mines[i + 1][j - 1]) count++;
                    if (i - 1 >= 0 && j + 1 < n  && mines[i - 1][j + 1]) count++;
                    if (i + 1 < m  && j + 1 < n  && mines[i + 1][j + 1]) count++;

                    if (j + 1 < n  && mines[i][j + 1]) count++;
                    if (j - 1 >= 0 && mines[i][j - 1]) count++;
                    if (i + 1 < m  && mines[i + 1][j]) count++;
                    if (i - 1 >= 0 && mines[i - 1][j]) count++;
                    System.out.print(count + "  ");
                }
            }
            System.out.println();
        }
    }
}