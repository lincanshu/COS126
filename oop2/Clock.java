/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Clock {

    private int h;
    private int m;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException();
        }
        this.h = h;
        this.m = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5 || s.charAt(2) != ':') {
            throw new IllegalArgumentException();
        }
        // 输入的参数有非数字
        for (int i = 0; i < s.length(); i++)
        {
            if (i != 2 && !Character.isDigit(s.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        this.h = Integer.parseInt(s.substring(0, 2));
        this.m = Integer.parseInt(s.substring(3, 5));
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException();
        }
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d", h, m);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.h == that.h) {
            return this.m < that.m;
        }
        return this.h < that.h;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        m += 1;
        h += m / 60;
        m %= 60;
        h %= 24;
    }


    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException();
        }
        m += delta;
        h += m / 60;
        m %= 60;
        h %= 24;
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock clock = new Clock(args[0]);
        StdOut.println(clock.toString());
        clock.tic();
        StdOut.println(clock.toString());
        clock.toc(60);
        StdOut.println(clock.toString());
    }
}