package com.tyss.typecasting.pack1;

public class Primitive {
///implici typecastingf
	byte b=4;
	short s=b;
	int i1=b;
	float f=b;
	double d=b;
	
	void values()
	{
		System.out.println("value of byte is "+b);
		System.out.println("value of short is "+s);
		System.out.println("value of int is "+i1);
		System.out.println("value of float is "+f);
		System.out.println("value of double is "+d);
	}
	///explicit typecasting
	
	double pi=3.142;
	int i2=(int) pi;
	void details()
	{
		System.out.println("integer value is "+b);
		System.out.println("double value is "+pi);
	}
}
