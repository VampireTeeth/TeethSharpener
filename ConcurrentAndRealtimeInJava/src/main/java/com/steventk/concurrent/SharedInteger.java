package com.steventk.concurrent;

public class SharedInteger {

    public SharedInteger(int initialValue) {
        this.value = initialValue;
    }
    
    public synchronized int read() {
        ThreadUtils.sleep(3 * 1000);
        return this.value;
    }
    
    public synchronized void write(int value) {
        ThreadUtils.sleep(3 * 1000);
        this.value = value;
    }
    
    public synchronized void incrementBy(int offset) {
        ThreadUtils.sleep(3 * 1000);
        this.value += offset;
    }
    
    private int value;
}
