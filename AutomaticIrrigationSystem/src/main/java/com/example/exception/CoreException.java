/**
 * Filename    : CoreException.java
 * Version     : 1.0.0
 * Create Date : 21 Apr 2022
 *
 * © Example
 */
package com.example.exception;

import org.springframework.http.HttpStatus;

public class CoreException extends Exception {
	
	private static final long serialVersionUID = -2783981304069957052L;

	private String errorCode;
	
	private String errorMessage;
	
	private HttpStatus httpStatus;

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @return the httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * Default Exception
	 * 
	 * @param errorCode
	 * @param errorMessage
	 * @param httpStatus
	 */
	public CoreException(String errorCode, String errorMessage, HttpStatus httpStatus) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}

}
