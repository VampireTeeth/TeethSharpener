package com.steventk.realtime;

import javax.realtime.AsyncEventHandler;
import javax.realtime.OneShotTimer;
import javax.realtime.RelativeTime;

public class WatchDogTimerTest {

    private static final int TIMEOUT = 2000;
    
    public static void main(String[] args) {
        
        class MyAEH extends AsyncEventHandler{
            @Override
            public void handleAsyncEvent() {
                System.err.println("Emergency reset!!!");
                System.exit(1);
            }
        }
        
        AsyncEventHandler handler = new MyAEH();
        RelativeTime timeout = new RelativeTime(TIMEOUT, 0);
        OneShotTimer watchDog = new OneShotTimer(timeout, handler);
        
        watchDog.start();
        while(true) {
            double d = Math.random();
            long n = (long)(d * TIMEOUT + 400);
            System.out.println("Running t = " + n);
            try {
                Thread.sleep(n);
            }catch(InterruptedException e) {}
            watchDog.reschedule(timeout);
        }
    }
}
