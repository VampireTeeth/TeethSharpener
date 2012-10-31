package com.steventk.realtime;

import javax.realtime.AsyncEventHandler;
import javax.realtime.PeriodicTimer;
import javax.realtime.RelativeTime;

public class PTimer {

    public static void main(String[] args) {
        AsyncEventHandler handler = new AsyncEventHandler() {
            int count = 0;
            public void handleAsyncEvent() {
                System.out.println("Tick " + (count++));
            }
        };
        
        PeriodicTimer timer = new PeriodicTimer(null, new RelativeTime(2000, 0), handler);
        timer.start();
        try {
            Thread.sleep(20 * 1000);
        }catch(InterruptedException e) {}
        timer.removeHandler(handler);
        System.exit(0);
    }
}
