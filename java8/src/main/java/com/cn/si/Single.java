package com.cn.si;

public class Single {
	private static  final Single SI = new Single();
	
	private Single(){};
	
	private static class InnerSingle{
		
		private static  Single create() {
			return  SI;
		}
		
	}
	
	public static Single createSingle()
	{
		return Single.InnerSingle.create();
	}
}
