package com.steventk.realtime;

import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
import javax.realtime.ReleaseParameters;
import javax.realtime.Scheduler;
import javax.realtime.SchedulingParameters;


public class Periodic1 {
    public static void main(String[] args) {
        SchedulingParameters scheduling = 
                new PriorityParameters(PriorityScheduler.instance().getMinPriority() + 10);
        
        ReleaseParameters release =
                new PeriodicParameters(new RelativeTime(), //start at .start()
                        new RelativeTime(1000, 0),//period
                        null,//cost 
                        new RelativeTime(500, 0),//deadline
                        null, //overrun handler
                        null);//miss handler
        
        RealtimeThread rt = new MyThread(scheduling, release);
//        RealtimeThread rt = new MyThread2(scheduling);
        rt.start();
        try {
            rt.join();
        }catch(InterruptedException e) {
        }
    }
    
    static class MyThread extends RealtimeThread{

        volatile double f;
        MyThread(SchedulingParameters scheduling,
                ReleaseParameters release) {
            super(scheduling, release);
        }
        
        @Override
        public void run() {
            int bound = 0;
            while(true) {
                do {
                    for(f = 0.0; f < bound; f+=1.0);
                    bound += 1000000;
                    System.out.println("Ding! " + bound);
                }while(waitForNextPeriod());
                //Recover from overrun or miss
                System.out.println("Scheduling error");
                bound -= 1500000;
                while(!waitForNextPeriod()) System.out.println(".");
                System.out.println();
            }
        }
        
    }
    
    static class MyThread2 extends RealtimeThread{
        volatile double f;
        
        MyThread2(SchedulingParameters scheduling){
            super(scheduling);
        }
        
        private ReleaseParameters mkRelease() {
            return new PeriodicParameters(
                    new RelativeTime(), 
                    new RelativeTime(1000, 0), 
                    null, 
                    new RelativeTime(500, 0), 
                    null, 
                    null);
        }
        @Override
        public void run() {
            ReleaseParameters release = mkRelease();
            RealtimeThread me = currentRealtimeThread();
            Scheduler scheduler = getScheduler();
            SchedulingParameters scheduling = getSchedulingParameters();
            System.out.println(scheduling);
            
            if(me.setReleaseParametersIfFeasible(release)) {
                int bound = 0;
                int limit = 50;
                while(true) {
                    do {
                        for(f = 0.0; f < bound ; f += 1.0);
                        bound += 1000000;
                        System.out.println("Ding! " + bound);
                        if(--limit <= 0) return;
                    }while(waitForNextPeriod());
                    //Recover from overrun or miss
                    System.out.println("Scheduling error");
                    bound -= 1500000;
                    while(!waitForNextPeriod()) System.out.println(".");
                    System.out.println();
                }
            }else {
                System.out.println("Load is not feasible.");
            }
        }
    }

}
