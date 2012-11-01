package com.steventk.realtime;

import javax.realtime.AsyncEvent;
import javax.realtime.AsyncEventHandler;
import javax.realtime.PriorityParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.SchedulingParameters;

public class FaultTriggeringTest {

	public static void main(String[] args) {
		RealtimeThread rt = new FaultTriggeredRTThread();
		rt.start();
		try{
			rt.join();
		}catch(InterruptedException e) {}
	}
	
	static class FaultTriggeredRTThread extends RealtimeThread{

		private int maxPriority = 0;
		@Override
		public void run() {
			AsyncEventHandler handler = new FaultTriggerAEH();
			AsyncEvent event = new AsyncEvent();
			RealtimeThread thisThread = RealtimeThread.currentRealtimeThread();
			maxPriority = thisThread.getPriority();
			System.out.println("maxPriority = " + maxPriority);
			SchedulingParameters scheduling = new PriorityParameters(maxPriority - 4);
			handler.setSchedulingParameters(scheduling);
			event.addHandler(handler);
			process1(event);
			event.removeHandler(handler);
		}
		
		private void process1(AsyncEvent event) {
			AsyncEventHandler handler = new Process1AEH();
			SchedulingParameters scheduling = new PriorityParameters(maxPriority - 3);
			handler.setSchedulingParameters(scheduling);
			event.addHandler(handler);
			process2(event);
			event.removeHandler(handler);
		}
		
		private void process2(AsyncEvent event) {
			//something bad happened here
			//fire the event
			event.fire();
		}
		
	}
	
	static class FaultTriggerAEH extends AsyncEventHandler {
		@Override
		public void handleAsyncEvent() {
			System.out.println("Run method: notified");
		}
	}
	
	static class Process1AEH extends AsyncEventHandler {
		@Override
		public void handleAsyncEvent() {
			System.out.println("process1 method: notified");
		}
	}
}
