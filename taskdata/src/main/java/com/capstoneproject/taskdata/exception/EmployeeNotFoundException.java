package com.capstoneproject.taskdata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "employee not found")
public class EmployeeNotFoundException extends Exception{
}
