/**
 * Filename    : SensorEntity.java
 * Version     : 1.0.0
 * Create Date : 21 Apr 2022
 *
 * © Example
 */
package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "Sensor")
@EqualsAndHashCode(callSuper=false)
@Data
public class SensorEntity extends AbstractEntity{
	
	@Column(name = "Sensor_Serial_Id", unique = true)
	private Long sensorSerialId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Manufacturer")
	private String manufacturer;
	
	@Column(name = "Throughput")
	private Long throughput;
	
	@Column(name = "Power_Consumption")
	private Long powerConsumption;
	
	@ManyToOne
	private PlotEntity plot;

}
