package com.steventk.concurrent;

public class SystemUtils {

    public static long timeElapsedSince(long past) {
        return System.currentTimeMillis() - past;
    }
}
