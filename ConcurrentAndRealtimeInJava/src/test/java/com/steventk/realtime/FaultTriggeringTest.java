package com.steventk.realtime;

import javax.realtime.AsyncEvent;
import javax.realtime.AsyncEventHandler;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.SchedulingParameters;

public class FaultTriggeringTest {

	public static void main(String[] args) {
		
	}
	
	static class FaultTriggeredRTThread implements Runnable{

		@Override
		public void run() {
			AsyncEventHandler handler = new FaultTriggerAEH();
			AsyncEvent event = new AsyncEvent();
			RealtimeThread thisThread = RealtimeThread.currentRealtimeThread();
			int maxPriority = PriorityScheduler.getMaxPriority(thisThread);
			SchedulingParameters scheduling = new PriorityParameters(maxPriority - 3);
			handler.setSchedulingParameters(scheduling);
			event.addHandler(handler);
			process1(event);
			event.removeHandler(handler);
		}
		
		private void process1(AsyncEvent event) {
			
		}
		
	}
	
	static class FaultTriggerAEH extends AsyncEventHandler {
		@Override
		public void handleAsyncEvent() {
			System.out.println("Run method: notified");
		}
	}
}
