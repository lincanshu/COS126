public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha)
    {
        double[] sound = new double[a.length];
        for (int i = 0; i < a.length; i++)
        {
            sound[i] = a[i] * alpha;
        }
        return sound;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a)
    {
        double[] sound = new double[a.length];
        for (int i = 0; i < a.length; i++)
        {
            sound[i] = a[a.length - 1 - i];
        }
        return sound;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b)
    {
        double[] sound = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++)
        {
            sound[i] = a[i];
        }
        for (int i = 0; i < b.length; i++)
        {
            sound[i + a.length] = b[i];
        }
        return sound;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b)
    {
        int length = Math.max(a.length, b.length);
        double[] sound = new double[length];
        for (int i = 0; i < length; i++)
        {
            if (i < a.length) sound[i] += a[i];
            if (i < b.length) sound[i] += b[i];
        }
        return sound;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha)
    {
        int n = a.length;
        double[] sound = new double[(int)(n / alpha)];
        for (int i = 0; i < sound.length; i++)
        {
            sound[i] = a[(int)(i * alpha)];
        }
        return sound;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args)
    {
        double[] a1 = StdAudio.read("beatbox.wav");
        double[] a2 = StdAudio.read("buzzer.wav");
        double[] a3 = StdAudio.read("cow.wav");
        double[] a4 = StdAudio.read("chimes.wav");
        double[] a5 = StdAudio.read("harp.wav");
        double[] result = new double[]{0.0};
        result = merge(result, a2);
        result = merge(result, a3);
        result = merge(result, a4);
        result = merge(result, a5);
        StdAudio.play(result);
    }
}