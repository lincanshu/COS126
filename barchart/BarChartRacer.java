/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        // 从命令行参数获取文件和条形个数k
        String filename = args[0];
        int k = Integer.parseInt(args[1]);
        // 读取文件
        In in = new In(filename);
        String title = in.readLine();
        String xAxisLabel = in.readLine();
        String dataSource = in.readLine();

        // 该对象用于后面的绘制
        BarChart barChart = new BarChart(title, xAxisLabel, dataSource);
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        StdAudio.loop("soundtrackB.wav");

        while (in.hasNextLine()) {
            in.readLine();
            int n = Integer.parseInt(in.readLine());
            String date = "";
            Bar[] bars = new Bar[n];
            for (int i = 0; i < n; i++) {
                String line = in.readLine();
                String[] arr = line.split(",");
                date = arr[0];
                String name = arr[1];
                String country = arr[2];
                int value = Integer.parseInt(arr[3]);
                String category = arr[4];
                bars[i] = new Bar(name, value, category);
            }
            Arrays.sort(bars);

            barChart.reset();
            barChart.setCaption(date);
            // 只绘制最大的k个条形
            for (int i = n - 1; i >= n - k; i--)
            {
                barChart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }
            // draw the bar chart
            StdDraw.clear();
            barChart.draw();
            StdDraw.show();
            StdDraw.pause(100);
        }
    }
}
