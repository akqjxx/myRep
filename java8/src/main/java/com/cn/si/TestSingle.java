package com.cn.si;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class TestSingle {
	
	
	@Test
	public void test() throws InterruptedException, ExecutionException {
		
		Set<Single> set = new HashSet<>();
		Callable<Single> task =()->{
			Single s = Single.createSingle();
			return s;
		};
		java.util.concurrent.ExecutorService  es = Executors.newFixedThreadPool(10);
		for(int i =0 ;i<10000;i++) {
			Future<Single> f  =  es.submit(task);
			set.add(f.get());
		}
		es.shutdown();
		
		set.forEach(System.out::println);
	}

}
