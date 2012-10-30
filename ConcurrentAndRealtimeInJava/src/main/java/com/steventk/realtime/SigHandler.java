package com.steventk.realtime;

import javax.realtime.AsyncEventHandler;

public class SigHandler extends AsyncEventHandler{
    
    @Override
    public void handleAsyncEvent() {
        int pending;
        while((pending = getAndDecrementPendingFireCount()) >= 1) {
            if(pending > 1) {
                System.out.println("Signal. " + pending + " pending");
            }else {
                System.out.println("Signal");
            }
        }
    }

}
