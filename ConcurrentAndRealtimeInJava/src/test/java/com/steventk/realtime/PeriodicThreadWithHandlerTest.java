package com.steventk.realtime;

import javax.realtime.AsyncEventHandler;
import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
import javax.realtime.ReleaseParameters;
import javax.realtime.SchedulingParameters;
import javax.xml.ws.AsyncHandler;

public class PeriodicThreadWithHandlerTest {

    static RealtimeThread rt;
	public static void main(String[] args) {
		SchedulingParameters scheduling = 
				new PriorityParameters(PriorityScheduler.instance().getMinPriority() + 20);
		ReleaseParameters release = 
				new PeriodicParameters(new RelativeTime(), 
						new RelativeTime(1000, 0), 
						new RelativeTime(500, 0), 
						new RelativeTime(500, 0), 
						new OverrunHandler(), 
						new MissHandler());
		rt = new PeriodicDummyThread(scheduling, release);
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
			while(!RealtimeThread.interrupted()) {
				long now = System.currentTimeMillis();
				for(int i = 0; i < bound; i++);// Comsuming some time
				bound += 1000*1000;//Use more time next loop
				long collpsed = System.currentTimeMillis() - now;
				for(;!waitForNextPeriod();System.out.println("."));
				System.out.println("["+ System.currentTimeMillis() +
        				"]Ding! " + bound + " - processing time is " + collpsed +
				        " milliseconds. " + "Return value of waitForNextPeriod() = " + running +
				        ".");
			}
		}
	}
	
	static class OverrunHandler extends AsyncEventHandler{
	    @Override
	    public void handleAsyncEvent() {
	        System.out.println("Overrun with current cost");
	        ReleaseParameters rp = rt.getReleaseParameters();
	        RelativeTime cost = rp.getCost();
	        rp.setCost(cost.add(1000, 0, cost));
	        rt.schedulePeriodic();
	    }
	}
	
	static class MissHandler extends AsyncEventHandler{
	    @Override
	    public void handleAsyncEvent() {
	        System.out.println("Miss deadline");
	        ReleaseParameters rp = rt.getReleaseParameters();
	        RelativeTime deadline = rp.getDeadline();
	        rp.setDeadline(deadline.add(1000, 0, deadline));
	        rt.schedulePeriodic();
	    }
	}
}

