package com.tyss.thread.creatingThread;

public class User extends Thread{
	PVR p;

	public User(PVR p) {
		super();
		this.p = p;
	}
	
    public void run()
    {
    	p.confirmTicket();
    }
}
