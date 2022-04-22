/**
 * Filename    : Irrigation.java
 * Version     : 1.0.0
 * Create Date : 22 Apr 2022
 *
 * © Example
 */
package com.example.models;

import java.util.Date;

import org.springframework.lang.NonNull;

import com.example.utils.IrrigationStatus;

import lombok.Data;

@Data
public class Irrigation {
	
	@NonNull
	private Date scheduleTime;
	
	@NonNull
	private Boolean isTimeBased;
	
	@NonNull
	private Long amount; //If time based no. of hours / else no of litres
		
	@NonNull
	private Boolean isReccurrent;
	
	private Integer status = IrrigationStatus.SCHEDULED.status;

}
