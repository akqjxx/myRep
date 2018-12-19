package com.cn;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestDateFormatJava8 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		DateTimeFormatter  dtf = DateTimeFormatter.ofPattern("uuuuMMdd HH:mm:ss");
		
	
	 Callable<LocalDateTime> call = () -> {
		 
				///return d.parse("20180303");
		 return  LocalDateTime.parse("20180303 00:03:32", dtf);
	};
	
 
		ExecutorService es = Executors.newFixedThreadPool(10);
		List<Future<LocalDateTime>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Future<LocalDateTime> f = es.submit(call);
			list.add(f);
		}
		for (Future<LocalDateTime> f1 : list) {
			System.out.println(f1.get().toString());
		}

		es.shutdown();

	}

}
