/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {

    private static int roundAndClamp(double value) {
        int res = (int) Math.round(value);
        res = Math.max(res, 0);
        res = Math.min(res, 255);
        return res;
    }

    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    private static Picture kernel(Picture picture, double[][] weights) {
        int h = picture.height(), w = picture.width();
        int m = weights.length, n = weights[0].length;
        Picture newPicture = new Picture(w, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                double r = 0, g = 0, b = 0;
                for (int ii = 0; ii < m; ii++) {
                    for (int jj = 0; jj < n; jj++) {
                        // we need to consider the started location
                        int row = (i + h + ii - m / 2) % h;
                        int col = (j + w + jj - n / 2) % w;
                        r += weights[ii][jj] * picture.get(col, row).getRed();
                        g += weights[ii][jj] * picture.get(col, row).getGreen();
                        b += weights[ii][jj] * picture.get(col, row).getBlue();
                    }
                }
                int red = roundAndClamp(r);
                int green = roundAndClamp(g);
                int blue = roundAndClamp(b);
                newPicture.set(j, i, new Color(red, green, blue));
            }
        }
        return newPicture;
    }

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] weights = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] weights = { { 1, 2, 1 }, { 2, 4, 2 }, { 1, 2, 1 } };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                weights[i][j] = weights[i][j] / 16;
            }
        }
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] weights = { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] weights = { { -1, -1, -1 }, { -1, 8, -1 }, { -1, -1, -1 } };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] weights = { { -2, -1, 0 }, { -1, 1, 1 }, { 0, 1, 2 } };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        int n = 9;
        double[][] weights = new double[n][n];
        for (int i = 0; i < n; i++) {
            weights[i][i] = 1.0 / n;
        }
        return kernel(picture, weights);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture picture = new Picture("6-by-5.png");
        picture = motionBlur(picture);
        picture = identity(picture);
        picture = gaussian(picture);
        picture = sharpen(picture);
        picture = laplacian(picture);
        picture = emboss(picture);
        picture.show();
    }
}