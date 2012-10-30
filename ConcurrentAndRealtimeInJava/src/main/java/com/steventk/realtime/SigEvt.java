package com.steventk.realtime;

import javax.realtime.AsyncEvent;
import javax.realtime.AsyncEventHandler;
import javax.realtime.ImmortalMemory;
import javax.realtime.MemoryArea;
import javax.realtime.RealtimeThread;

public class SigEvt extends RealtimeThread{
    
    @Override
    public void run() {
        System.out.println("Realtime thread " + getName() + " started.");
        MemoryArea immortal = ImmortalMemory.instance();
        System.out.println("ImmortalMemory instantiated " + immortal.memoryRemaining() + " bytes remains.");
        System.out.println("ImmortalMemory instantiated " + immortal.memoryConsumed() + " bytes consumed.");
        AsyncEventHandler handler = null;
        AsyncEvent event = null;
        try {
            handler = (AsyncEventHandler)immortal.newInstance(SigHandler.class);
            event = (AsyncEvent)immortal.newInstance(AsyncEvent.class);
        }catch(Throwable e) {
            System.err.println("Error occurs: ");
            e.printStackTrace(System.err);
            return;
        }
        
        System.out.println("Handler and event instantiated.");
        event.addHandler(handler);
        event.bindTo("25");
        event.fire();
        try {
            Thread.sleep(1000);
        }catch(InterruptedException ign) {}
    }
    
    public static void main(String[] args) {
        RealtimeThread rt = new SigEvt();
        rt.start();
        
        try {
            rt.join();
        } catch (InterruptedException e) {
        }
        System.exit(0);
    }
}
