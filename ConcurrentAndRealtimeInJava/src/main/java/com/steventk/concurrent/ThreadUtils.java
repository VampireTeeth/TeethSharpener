package com.steventk.concurrent;

public class ThreadUtils {

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        }catch(InterruptedException ign) {}
    }
}
