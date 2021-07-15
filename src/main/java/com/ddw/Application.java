package com.ddw;

public class Application {

    /**
     * 计算机中二进制用补码表示
     *
     * 有符号右移：
     *      正数高位补0（不打印出来）
     *      负数高位补1
     *
     * 无符号数右移：
     *      正负数高位补0
     * @param args
     */
    public static void main(String[] args) {
        int a = -14;
        int b = -25;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(b >>= 1));
        System.out.println(Integer.toBinaryString(b >>>= 1));
        System.out.println(b);
        int c = a ^ b;
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toBinaryString(c >>= 1));
        System.out.println(Integer.toBinaryString(c >>>= 1));
        System.out.println("com.ddw.Application works well!");
    }
}
