package org.idb.exception;

public class UserBlockException extends Exception {
	
	//it works when user is Active
	public UserBlockException() {

	}

	// with error  and it works when user is not Active
	public UserBlockException(String errMessage) {
			super(errMessage);
	}

}
