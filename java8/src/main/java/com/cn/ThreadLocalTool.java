package com.cn;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalTool extends ThreadLocal<DateFormat> {
	
	@Override
	protected DateFormat initialValue() {
		return  new SimpleDateFormat("yyyyMMdd");
	}
	
	 ////private ThreadLocal<DateFormat> tdf = new ThreadLocal<DateFormat>();
	
	public   Date convert(String src) throws ParseException
	{
		return initialValue().parse(src);
	}

}
