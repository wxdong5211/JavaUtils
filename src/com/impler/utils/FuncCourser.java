package com.impler.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 猎犬模式
 * @author Invalid
 */
public class FuncCourser {
	
	private FuncCourser(){}
	
	private static ExecutorService executor = Executors.newCachedThreadPool(new ThreadFactory() {
		
		private int count;
		
		@Override
		public Thread newThread(Runnable task) {
			count++;
			Thread invoke = new Thread(task);
			invoke.setName("InvokeThread-"+count);
			invoke.setDaemon(true);
			return invoke;
		}
		
	});
	
	public static <T> T call(Callable<T> task, TimeUnit unit, long timeout) throws TimeoutException{
		Future<T> handler = executor.submit(task);
		T result;
		try {
			result = handler.get(timeout, unit);
		} catch (Exception e) {
			if(e instanceof TimeoutException)
				throw new TimeoutException("invoke timeout");
			throw new RuntimeException(e);
		}
		return result;
	}
	
	public static void call(Runnable task, TimeUnit unit, long timeout) throws TimeoutException{
		Future<?> handler = executor.submit(task);
		try {
			handler.get(timeout, unit);
		} catch (Exception e) {
			if(e instanceof TimeoutException)
				throw new TimeoutException("invoke timeout");
			throw new RuntimeException(e);
		}
	}

}
