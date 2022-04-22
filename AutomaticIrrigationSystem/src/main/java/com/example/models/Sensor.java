/**
 * Filename    : Sensor.java
 * Version     : 1.0.0
 * Create Date : 21 Apr 2022
 *
 * © Example
 */
package com.example.models;

import lombok.Data;

@Data
public class Sensor {
	
	private Long sensorSerialId;
	
	private String name;
	
	private String manufacturer;
	
	private Long throughput;  //Assuming in litres
	
	private Long powerConsumption; //Assuming in KWH
	
}
