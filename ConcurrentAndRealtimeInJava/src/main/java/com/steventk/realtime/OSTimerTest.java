package com.steventk.realtime;

import javax.realtime.AsyncEventHandler;
import javax.realtime.OneShotTimer;
import javax.realtime.RelativeTime;

public class OSTimerTest {

    static volatile boolean stopLooping = false;
    
    public static void main(String[] args) {
        class MyAEH extends AsyncEventHandler{
            @Override
            public void handleAsyncEvent() {
                stopLooping = true;
            }
        }
        AsyncEventHandler handler = new MyAEH();
        OneShotTimer timer = new OneShotTimer(new RelativeTime(10*1000, 0), handler);
        timer.start();
        while(!stopLooping) {
            System.out.println("Running...");
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {}
        }
    }
}
