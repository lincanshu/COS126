public class ThueMorse
{
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        char[] seq = new char[2 * n];
        int index = 0;
        seq[index++] = '0';
        for (int i = 1; i < n; i <<= 1)
        {
            for (int J = index, j = 0; j < J; j++)
            {
                seq[index++] = seq[j] == '0' ? '1' : '0';
            }
        }
        // System.out.println(seq);
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (seq[i] == seq[j])
                {
                    System.out.print("+  ");
                }
                else
                {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}