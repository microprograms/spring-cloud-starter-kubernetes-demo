package com.github.microprograms.spring_cloud_starter_kubernetes_demo.utils;

public class Pi {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        double pi = grid_pi(999999999);
        long end = System.currentTimeMillis();
        System.out.println(String.format("grid_pi, result=%s, cost=%sms", pi, end - start));
    }

    /**
     * 蒙特卡罗法计算π
     * 
     * @param n 投入点的个数, 示例值Integer.MAX_VALUE
     * @return
     */
    public static double rand_pi(int n) {
        int numInCircle = 0;
        double x, y;
        double pi;
        for (int i = 0; i < n; i++) {
            x = Math.random();
            y = Math.random();
            if (x * x + y * y < 1)
                numInCircle++;
        }
        pi = (4.0 * numInCircle) / n;
        return pi;
    }

    /**
     * 数学公式（级数）计算π
     * 
     * @param n 示例值1000
     * @return
     */
    public static double math_pi(int n) {
        double sum = 0;
        double pi;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / (i * i);
        }
        pi = Math.sqrt(sum * 6);
        return pi;
    }

    /**
     * 划分网格计算π
     * 
     * @param n 示例值10
     * @return
     */
    public static double grid_pi(int n) {
        int i;
        double sum = 0;
        for (i = 0; i < n; i++) {
            sum += (int) Math.sqrt(n * (double) n - i * (double) i);
        }
        return (4.0 * sum) / n / n;
    }
}
