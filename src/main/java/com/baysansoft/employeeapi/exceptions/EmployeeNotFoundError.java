package com.baysansoft.employeeapi.exceptions;

public class EmployeeNotFoundError extends RuntimeException {

    public EmployeeNotFoundError() {
    }

    public EmployeeNotFoundError(String arg0) {
        super(arg0);
    }

    public EmployeeNotFoundError(Throwable arg0) {
        super(arg0);
    }

    public EmployeeNotFoundError(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public EmployeeNotFoundError(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

}
