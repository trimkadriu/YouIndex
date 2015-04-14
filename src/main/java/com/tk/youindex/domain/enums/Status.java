package com.tk.youindex.domain.enums;

/**
 * Status definition enum
 * @author trim.kadriu
 */
public enum Status {
	/**
	 * OK - enabled, active
	 */
	OK,
	/**
	 * NO - disabled, inactive
	 */
	NO;
	
	public static Status fromString(String input){
		for(Status s: values()){
			if(s.name().equals(input))
				return s;
		}
		return null;
	}
}
