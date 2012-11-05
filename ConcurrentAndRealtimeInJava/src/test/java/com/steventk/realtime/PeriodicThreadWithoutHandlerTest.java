package com.steventk.realtime;

import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
import javax.realtime.ReleaseParameters;
import javax.realtime.SchedulingParameters;

public class PeriodicThreadWithoutHandlerTest {

	public static void main(String[] args) {
		SchedulingParameters scheduling = 
				new PriorityParameters(PriorityScheduler.instance().getMinPriority() + 20);
		ReleaseParameters release = 
				new PeriodicParameters(new RelativeTime(), 
						new RelativeTime(1000, 0), 
						null, 
						new RelativeTime(500, 0), 
						null, 
						null);
		RealtimeThread rt = new PeriodicDummyThread(scheduling, release);
		rt.start();
		try{
			rt.join();
		}catch(InterruptedException e){}
	}
	
	static class PeriodicDummyThread extends RealtimeThread{
		
		
		public PeriodicDummyThread(SchedulingParameters scheduling,
				ReleaseParameters release) {
			super(scheduling, release);
		}

		@Override
		public void run() {
			boolean running = true;
			int bound = 0;
			while(running) {
				long now = System.currentTimeMillis();
				for(int i = 0; i < bound; i++);// Comsuming some time
				bound += 1000*1000;//Use more time next loop
				long collpsed = System.currentTimeMillis() - now;
				System.out.println("Ding! " + bound + " - processing time is " + collpsed + " milliseconds.");
				running = waitForNextPeriod();
			}
		}
	}
}

