public class EvenOrOdd
{
	public static void main(String[] args)
	{
		Outside:
		while (!StdIn.isEmpty())
		{
			char[] array = StdIn.readString().toCharArray();
			for (int i = 0; i < array.length; i++) 
			{
				if (array[i] < '0' || array[i] > '9')
				{
					StdOut.println("Not a number");
					continue Outside;
				}
			}
			int n = array[array.length - 1];
			if (n % 2 == 0) {
				StdOut.println("even");
			}
			else {
				StdOut.println("odd");
			}
		}
	}

}
