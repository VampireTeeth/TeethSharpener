package com.steventk.concurrent;

public class ShreadIntegerCompetition {

    public static void main(String[] args) {
        SharedInteger shared = new SharedInteger(3);
        WritingThread wt = new WritingThread(shared);
        ReadingThread rt = new ReadingThread(shared);
        wt.start();
        rt.start();
    }
    
    static class WritingThread extends Thread{
        private SharedInteger shared;
        
        public WritingThread(SharedInteger shared) {
            this.shared = shared;
        }
        
        @Override
        public void run() {
            long now = System.currentTimeMillis();
            shared.write(1000);
            System.out.println("Thread "+Thread.currentThread().getName()+
                    " writes the shared integer: after "+
                    SystemUtils.timeElapsedSince(now)+" milliseconds.");
        }
    }
    
    static class ReadingThread extends Thread{
        private SharedInteger shared;
        
        public ReadingThread(SharedInteger shared) {
            this.shared = shared;
        }
        
        @Override
        public void run() {
            long now = System.currentTimeMillis();
            int val = shared.read();
            System.out.println("Thread "+Thread.currentThread().getName()+
                    " reads the shared integer:"+val + " after "+
                    SystemUtils.timeElapsedSince(now)+" milliseconds.");
            
        }
    }
}
