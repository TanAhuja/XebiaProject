/**
 * Filename    : IrrigationStatus.java
 * Version     : 1.0.0
 * Create Date : 22 Apr 2022
 *
 * © Example
 */
package com.example.utils;

public enum IrrigationStatus {
	
	SCHEDULED(0), RUNNING(1), COMPLETED(2), RETRY(3), FAILED(4);
	
	public final int status;
	
	private IrrigationStatus(int status) {
		this.status = status;
	}

}
