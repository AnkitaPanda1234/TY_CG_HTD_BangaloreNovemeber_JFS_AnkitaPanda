package com.tyss.thread.creatingThread;

public class Thread1 extends Thread {
	public void run()
	{
		for (int i = 0; i <4; i++) {
			System.out.println(i);
			
		}
	}
}
