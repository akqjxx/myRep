package com.cn.si;

public class Single {
	private static  Single si = new Single();
	
	private Single(){};
	
	private static class InnerSingle{
		
		private static  Single create() {
			return  si;
		}
		
	}
	
	public static Single createSingle()
	{
		return Single.InnerSingle.create();
	}
}
