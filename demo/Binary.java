public class Binary
{
	public static String convert(int N)
	{
		if (N == 0) return "0";
		if (N == 1) return "1";
		return convert(N/2) + (N % 2);
	}
	public static void main(String[] args)
	{
		int N = Integer.parseInt(args[0]);
		StdOut.println(convert(N));
	}
}
/**
 * convert(10)
 * return convert(5) + 0
 * return convert(2) + 1 + 0
 * return convert(1) + 0 + 1 + 0;
 * return 1 + 0 + 1 + 1;
 * return "1010"
 */
