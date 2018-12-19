package com.cn.date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

public class TestLocalDateTime {
	

	//Zone 时区
	@Test
	public void test7() {
		
		ZoneId.getAvailableZoneIds().forEach(System.out::println);
		
	}
	
	//Zone 时区
	@Test
	public void test6() {
		
		ZoneId.getAvailableZoneIds().forEach(System.out::println);
		
	}
	
	
	
	///DateTimeFormatter  格式化
	@Test
	public void test5() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd HH-mm-ss");
		LocalDateTime ld = LocalDateTime.now();
		String str = ld.format(dtf);
		String str1 = dtf.format(ld);
		System.out.println(str);
		System.out.println(str1);
		 
		
		LocalDateTime d = LocalDateTime.parse(str,dtf);
		String str3 = d.format(dtf);
		
		System.out.println(d);
		System.out.println(str3);
	}
	
	
	
	
	///时间矫正器 TemporalAdjusters 
	@Test
	public void test4() {
		
		LocalDateTime ldt = LocalDateTime.now();
		
		LocalDateTime ldt1 = ldt.with(TemporalAdjusters.lastInMonth(DayOfWeek.SATURDAY));
		System.out.println(ldt1);
		 
	}
	
	
	
	
	
	
	
	//Duration计算时间之间的间隔   Period 计算日期之间的间隔
	@Test
	public void test3() throws InterruptedException {
		
		Instant t1  = Instant.now();
		Thread.sleep(1000);
		
		Instant t2  = Instant.now();
		
		Duration  d = Duration.between(t1, t2);
		System.out.println(d.toMillis());
		System.out.println("----------------------");
		
		LocalTime lt1 = LocalTime.now();
		
		Thread.sleep(1000);
		LocalTime lt2 = LocalTime.now();
		Duration  d1 = Duration.between(lt1, lt2);
		System.out.println(d1.toMillis());
		
	}
	
	//Instant 时间戳
	@Test
	public void test2() {
		
		//Instant in = Instant.now(Clock.offset(Clock.systemDefaultZone(), Duration.ofHours(8).plusHours(1)));
		Instant in = Instant.now();
		OffsetDateTime of = in.atOffset(ZoneOffset.ofHours(8)) ;
		System.out.println(in.toString()  + "   " + of );
		System.out.println(in.toEpochMilli());
		//1545150085093
		//1545117696648
		  //1545117726418
		
	}
	
	//LocalDateTime
	@Test
	public void test1() {
		
		LocalDateTime ldt = LocalDateTime.now();
		
		
		String s  = ldt.format(DateTimeFormatter.ofPattern("uuuuMMdd"));
		
		LocalDateTime l  = ldt.plusYears(10);
		
 
		System.out.println(ldt +"  "+ s +"  "+ l);
		
		
		
		
		
	}
	

}
