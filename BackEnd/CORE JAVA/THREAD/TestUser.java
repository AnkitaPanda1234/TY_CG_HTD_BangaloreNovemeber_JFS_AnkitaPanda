package com.tyss.thread.creatingThread;

public class TestUser {
	public static void main(String[] args) {
		System.out.println("main started");
		PVR p=new PVR();
		User u1=new User(p);
		u1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main ended");
		p.leaveMe();
	}

}
