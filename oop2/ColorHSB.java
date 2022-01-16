/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ColorHSB {

    private final int h, s, b;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100)
        {
            throw new IllegalArgumentException();
        }
        this.h = h;
        this.s = s;
        this.b = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + h + ", " + s + ", " + b + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return s == 0 || b == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException();
        }
        int res = 0;
        int h1 = this.h, h2 = that.h;
        int s1 = this.s, s2 = that.s;
        int b1 = this.b, b2 = that.b;
        res += Math.min((h1 - h2) * (h1 - h2), (360 - Math.abs(h1 - h2)) * (360 - Math.abs(h1 - h2)));
        res += (s1 - s2) * (s1 - s2);
        res += (b1 - b2) * (b1 - b2);
        return res;
    }


    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB color = new ColorHSB(h, s, b);
        String name = null;
        ColorHSB ans = null;
        int min = Integer.MAX_VALUE;

        while (!StdIn.isEmpty())
        {
            String tmpName = StdIn.readString();
            h = Integer.parseInt(StdIn.readString());
            s = Integer.parseInt(StdIn.readString());
            b = Integer.parseInt(StdIn.readString());
            ColorHSB tmpColor = new ColorHSB(h, s, b);
            int dist = color.distanceSquaredTo(tmpColor);
            if (min > dist)
            {
                min = dist;
                name = tmpName;
                ans = tmpColor;
            }
        }
        StdOut.println(name + " " + ans);
    }
}