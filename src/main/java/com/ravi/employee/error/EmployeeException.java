package com.ravi.employee.error;

public class EmployeeException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EmployeeException() {
		super();
	}
	
	public EmployeeException(String errorMessage) {
		super(errorMessage);
	}
	
	public EmployeeException(Exception e) {
		super(e);
	}
	
	public EmployeeException(Throwable thr) {
		super(thr);
	}

}
