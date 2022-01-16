/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k)
    {
        if (n == 0 && k == 0)
        {
            return 1;
        }
        if (k < -n || k > n)
        {
            return 0;
        }
        // 原始数组
        long[] arr = new long[2*n + 1];
        // 辅助数组
        long[] aux = new long[2*n + 1];

        // n表示原始最中间的位置
        arr[n] = 1;
        for (int i = 1; i <= n; i++)
        {
            for (int j = 0; j <= 2*n; j++)
            {
                aux[j] = arr[j];
            }
            aux[n] = arr[n - 1] + arr[n] + arr[n + 1];
            for (int j = 1; j <= i; j++)
            {
                // 防止越界
                if (n - j - 1 < 0)
                {
                    aux[n - j] = 0;
                }
                else
                {
                    aux[n - j] = arr[n - j - 1];
                }
                aux[n - j] += arr[n - j] + arr[n - j + 1];
            }
            for (int j = 1; j <= i; j++)
            {
                // 防止越界
                if (n - j - 1 < 0)
                {
                    aux[n + j] = 0;
                }
                else
                {
                    aux[n + j] = arr[n + j + 1];
                }
                aux[n + j] += arr[n + j - 1] + arr[n + j];
            }
            // 恢复为原来的数组
            for (int j = 0; j <= 2*n; j++)
            {
                arr[j] = aux[j];
            }
        }
        return arr[n + k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}