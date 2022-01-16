public class Factors
{
	public static void main(String[] args)
	{
		long n = Long.parseLong(args[0]);
		for (int i = 0; i < n; i++)
		{
			while (n % i == 0)
			{
				System.out.println(i + " ");
				n = n / i;
			}
		}
	}
}
