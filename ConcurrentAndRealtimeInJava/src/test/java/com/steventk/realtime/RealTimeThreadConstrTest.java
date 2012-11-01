package com.steventk.realtime;

import javax.realtime.AperiodicParameters;
import javax.realtime.HeapMemory;
import javax.realtime.MemoryArea;
import javax.realtime.MemoryParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.ProcessingGroupParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.ReleaseParameters;
import javax.realtime.SchedulingParameters;

public class RealTimeThreadConstrTest {

	public static void main(String[] args) {
		SchedulingParameters scheduling = 
				new PriorityParameters(PriorityScheduler.getMinPriority(Thread.currentThread())+ 20);
		ReleaseParameters release = 
				new AperiodicParameters(null, null, null, null);
		MemoryParameters memory = 
				new MemoryParameters(MemoryParameters.NO_MAX, 0);
		MemoryArea area = HeapMemory.instance();
		ProcessingGroupParameters group = null;
		Runnable logic = new MyThread();
		
		RealtimeThread rt = new RealtimeThread(scheduling, release, memory, area, group, logic);
		rt.start();
		try{
			rt.join();
		}catch(InterruptedException e) {}
	}
	
	
	static class MyThread implements Runnable{

		@Override
		public void run() {
			System.out.println("This is run() from MyThread instance [" + this.hashCode()+ "]");
		}
		
	}
}
