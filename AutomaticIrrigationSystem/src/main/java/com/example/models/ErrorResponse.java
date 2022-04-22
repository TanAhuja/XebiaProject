/**
 * Filename    : ErrorResponse.java
 * Version     : 1.0.0
 * Create Date : 21 Apr 2022
 *
 * © Example
 */
package com.example.models;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private String errorCode;
	
	private String errorMessage;

}
