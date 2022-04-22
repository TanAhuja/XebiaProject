/**
 * Filename    : IrrigationEntity.java
 * Version     : 1.0.0
 * Create Date : 22 Apr 2022
 *
 * © Example
 */
package com.example.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "Irrigation")
@EqualsAndHashCode(callSuper=false)
@Data
public class IrrigationEntity extends AbstractEntity {
	
	@Column(name = "Schedule_Time")
	private Date scheduleTime;
	
	@Column(name = "Is_Time_Based")
	private Boolean isTimeBased;
	
	@Column(name = "Amount")
	private Long amount; //If time based no. of hours / else no of litres
	
	@Column(name = "Status")
	private Integer status;
	
	@Column(name = "Is_Reccurrent")
	private Boolean isReccurrent;

}
