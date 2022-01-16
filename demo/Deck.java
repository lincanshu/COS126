public class Deck 
{
	public static void main(String[] args)
	{
		String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		String[] suit = {"黑桃", "方块", "红桃", "黑梅"};

		String[] deck = new String[52];
		for (int j = 0; j < 4; j++)
		{
			for (int i = 0; i < 13; i++)
			{
				deck[i + 13*j] = rank[i] + suit[j];
				System.out.print(deck[i + 13*j] + " ");
			}
			System.out.println();
		}
	}
}
