package com.capgemini.springcore.overriding;

import java.io.IOException;
import java.util.Vector;

public class SubClass extends SuperClass{
	@Override
	protected Vector<Object> method() throws IOException
	{
		return null; //we can change the return type of method in subclass
	}
	
}
