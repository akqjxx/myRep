package com.cn;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestDateFormat {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//  DateFormat d = new SimpleDateFormat("yyyyMMdd");
		//  ThreadLocalTool t = new ThreadLocalTool();
	
	 Callable<Date> call = () -> {
		  ThreadLocalTool t = new ThreadLocalTool();
				///return d.parse("20180303");
		 return t.convert("20180203");
	};
	
/*	  
	Callable<Date> call = new Callable<Date>() {

			@Override
			public Date call() throws Exception {
				return d.parse("20180303");
			}
		};
*/
		ExecutorService es = Executors.newFixedThreadPool(10);
		List<Future<Date>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Future<Date> f = es.submit(call);
			list.add(f);
		}
		for (Future<Date> f1 : list) {
			System.out.println(f1.get().toString());
		}

		es.shutdown();

	}

}
