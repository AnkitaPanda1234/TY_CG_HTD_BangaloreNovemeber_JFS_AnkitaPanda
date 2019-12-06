package com.tyss.thread.creatingThread;

public class TestUser1 {
	public static void main(String[] args) {
		System.out.println("main started");
		IRCTC i1= new IRCTC();
		User1 u1=new User1(i1);
		u1.start();
		User1 u2= new User1(i1);
		u2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i1.leaveMe();
		System.out.println("main ended");
	}

}
