package com.tyss.bank.genericutility;

import java.time.LocalDateTime;
/**
 * @author abhijith s
 * common java logic codes will be written here
 */
public class JavaUtility {
	
	public LocalDateTime getSystemTime() {
		return LocalDateTime.now();
	}
	
	public int getRandomNumbers() {
		return (int)Math.random();
	}
}
