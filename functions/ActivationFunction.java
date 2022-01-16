public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x)
    {
        if (Double.isNaN(x))
        {
            return Double.NaN;
        }
        if (x < 0) {
            return 0;
        }
        else if (x > 0) {
            return 1;
        }
        else 
            return 0.5;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x)
    {
        if (Double.isNaN(x))
        {
            return Double.NaN;
        }
        return 1 / (1 + Math.exp(-x));
        // return 1 / (1 + Math.pow(Math.E, -x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x)
    {
        if (x == Double.MAX_VALUE)
        {
            return 1.0;
        }
        else if (x == -Double.MAX_VALUE)
        {
            return -1.0;
        }
        else if (x == Double.POSITIVE_INFINITY)
        {
            return 1.0;
        }
        else if (x == Double.NEGATIVE_INFINITY)
        {
            return -1.0;
        }
        else if (Double.isNaN(x))
        {
            return Double.NaN;
        }
        return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x)
    {
        if (x == Double.POSITIVE_INFINITY)
        {
            return 1;
        }
        else if (x == Double.NEGATIVE_INFINITY)
        {
            return -1;
        }
        else if (Double.isNaN(x))
        {
            return Double.NaN;
        }
        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x)
    {
        if (Double.isNaN(x))
        {
            return Double.NaN;
        }
        if (x <= -2)
        {
            return -1;
        }
        else if (x < 0)
        {
            return x + x*x / 4;
        }
        else if (x < 2)
        {
            return x - x*x / 4;
        }
        else
        {
            return 1;
        }
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args)
    {
        double x = Double.parseDouble(args[0]);
        StdOut.println("heaviside" + "(" + x + ") = " + heaviside(x));
        StdOut.println("sigmoid" + "(" + x + ") = " + sigmoid(x));
        StdOut.println("tanh" + "(" + x + ") = " + tanh(x));
        StdOut.println("softsign" + "(" + x + ") = " + softsign(x));
        StdOut.println("sqnl" + "(" + x + ") = " + sqnl(x));
    }
}