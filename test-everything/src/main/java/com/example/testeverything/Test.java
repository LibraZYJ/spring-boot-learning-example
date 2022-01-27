package com.example.testeverything;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author Yujie_Zhao
 * @date 2022/1/19 9:30
 */
public class Test {
    public static void main(String[] args) {
        char[] chars = new char[]{'\u0097'};
        String str = new String(chars);
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));
    }
}   
