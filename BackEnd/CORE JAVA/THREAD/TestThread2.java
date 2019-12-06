package com.tyss.thread.creatingThread;

public class TestThread2 {

	public static void main(String[] args) {
		System.out.println("main started");
		Thread2 t1=new Thread2(); //object for runnable interface
		Thread t2=new Thread(t1);//object for thread class
		t2.start();
		System.out.println("main ended");
	}

}
