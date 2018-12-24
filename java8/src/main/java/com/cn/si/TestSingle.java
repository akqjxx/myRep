package com.cn.si;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class TestSingle {

	@Test
	public void test() throws InterruptedException, ExecutionException {
		Set<Single> set = new LinkedHashSet<>() ;
		Callable<Single> task = () -> Single.createSingle();
		ExecutorService es = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100000; i++) {
			set.add(es.submit(task).get());
		}
<<<<<<< HEAD
		es.shutdown(); 
=======
		es.shutdown();
>>>>>>> branch 'master' of https://github.com/akqjxx/myRep.git
		set.forEach(System.out::println);
	}
}
