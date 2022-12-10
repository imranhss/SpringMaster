package org.idb.exception;



public class UserBlockException extends Exception {

	// without Error
	public UserBlockException() {

	}

	// with error 
	public UserBlockException(String errMessage) {
			super(errMessage);
	}
}
