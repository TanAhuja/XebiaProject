/**
 * Filename    : IrrigationSensorGateway.java
 * Version     : 1.0.0
 * Create Date : 22 Apr 2022
 *
 * © Example
 */
package com.example.gateway;

public interface IrrigationSensorGateway {

	/**
	 * This method sends command to sensors to run for specified time
	 * 
	 * @param hours
	 * @return
	 */
	public boolean executeIrrigationByTime(Long hours);

	/**
	 * This method sends command to sensors to run for specified volume
	 * 
	 * @param litres
	 * @return
	 */
	public boolean executeIrrigationByVolumne(Long litres);

}
