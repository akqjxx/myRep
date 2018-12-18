package com.cn;
 
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.cn.model.User;

public class TestJava8 {
	List<User> list = null; 
	@Before
	public void t() { 
		list =  Arrays.asList(
				new User(1,"张三",10),
				new User(2,"李四",11),
				new User(3,"王五",12),
				new User(4,"赵六",13), 
				new User(1,"田七",10)  
				);
	}
	
	@Test
	public void test1() {
		Map<Integer,List<User>> map  = list.stream().collect(Collectors.groupingBy((x)->x.getAge()));
		System.out.println(map);
	}
	@Test
	public void test2() {
		 list.stream().map(User::getName).forEach(System.out::println);;
	}
	@Test
	public void test3() {
		 Boolean b = list.stream().anyMatch( (x)->x.getAge()>10  ) ;
		 System.out.println(b);
	}
	@Test
	public void test4() {
	  Optional<Integer> t    =list.stream().map(User::getId).reduce( Integer::sum ) ;
	  
	  
	   Optional<String> s =    list.stream().map( (x) ->x.getName() ).reduce( String::concat ) ;
	
	   String s1 = list.stream().map( (x) ->x.getName() ).reduce("hello", (x,y)-> x .concat(y) ) ;
	
	   
	   System.out.println( s +"----" + s1 );
	
	  
	  System.out.println(t.get());
	  ///10 ：表示起始值
	  Integer t1    =list.stream().map(User::getId).reduce(10,(x,y)->x+y ) ;
	  System.out.println(t1);
	}
	@Test
	public void test5() {
		  // HashSet<String> set = list.stream().map(User::getName).collect(Collectors.toCollection(()->new HashSet<>()));
		   HashSet<String> set = list.stream().map(User::getName).collect(Collectors.toCollection( HashSet::new));
		   System.out.println(set);
	}								
	@Test
	public void test6() {
		    Double d = list.stream().map(User::getId).collect(Collectors.averagingDouble( (x)->x )) ;
		    Double d1 = list.stream().collect(Collectors.averagingDouble( (x)->x.getId())) ;
		    System.out.println(d+"   "+d1);
		    
		    System.out.println("-----------------------------------------");

		    Long l = list.stream().collect(Collectors.summingLong(User::getId));
		    Long l1 = list.stream().map(User::getId).collect(Collectors.summingLong( (x)->x ));
		    Optional<Integer> i =  list.stream().map(User::getId).reduce(Integer::sum);
		    System.out.println(l + "  "+ l1 +"   " + i.get());
		    System.out.println("--------------------最大值---------------------");
//		    Optional<User> u = list.stream().collect(Collectors.maxBy( (x,y) ->{return -Integer.compare(x.getAge(), y.getAge()); } ));
		    Optional<User> u = list.stream().collect(Collectors.maxBy( (x,y) ->Integer.compare(x.getAge(), y.getAge()) ));
		    System.out.println(u.get());
		    System.out.println("-------------------- ---------------------");
		    
		    Callable<Date> c   = ()->  new Date();
		    
	}		
	
	

}
