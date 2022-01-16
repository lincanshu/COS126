public class PlayThatTune
{
	public static double[] tone(double hz, double duration)
	{
		int N = (int) (44100 * duration);
		double[] a = new double[N+1];
		for (int i = 0; i <= N; i++)
			a[i] = Math.sin(2 * Math.PI * i * hz / 44100);
		return a;
	}
	
	private static double[] avg(double[] a, double[] b)
	{
		double[] c = new double[a.length];
		for (int i = 0; i < c.length; i++)
		{
			c[i] = (a[i] + b[i]) / 2.0;
		}
		return c;
	}

	private static double[] sum(double[] a, double[] b)
	{
		double[] c = new double[a.length];
		for (int i = 0; i < c.length; i++)
		{
			c[i] = a[i] + b[i];
		}
		return c;
	}

	public static double[] note(int pitch, double duration)
	{
		double hz = 440.0 * Math.pow(2, pitch / 12.0);
		double[] a = tone(1.0 * hz, duration);
		double[] hi = tone(1.0 * hz, duration);
		double[] lo = tone(1.0 * hz, duration);
		double[] harmonic = sum(hi, lo);
		return avg(a, harmonic);
	}

	public static void main(String[] args)
	{
		double tempo = Double.parseDouble(args[0]);
		while (!StdIn.isEmpty())
		{
			int pitch = StdIn.readInt();
			double duration = StdIn.readDouble() * tempo;
			double[] a = note(pitch, duration);
			StdAudio.play(a);
		}
		StdAudio.close();
	}
}
