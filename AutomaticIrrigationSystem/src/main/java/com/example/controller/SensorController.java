/**
 * Filename    : SensorController.java
 * Version     : 1.0.0
 * Create Date : 22 Apr 2022
 *
 * © Example
 */
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.CoreException;
import com.example.models.Response;
import com.example.models.Sensor;
import com.example.services.SensorService;

@RestController
@RequestMapping("/sensors")
public class SensorController {

	@Autowired
	SensorService sensorService;

	@PostMapping
	public ResponseEntity<Response> createSensor(@RequestBody Sensor sensor) throws CoreException {
		Response response = sensorService.createSensor(sensor);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Sensor>> getAllSensors() throws CoreException {
		List<Sensor> sensors = sensorService.getAllSensors();
		return new ResponseEntity<>(sensors, HttpStatus.OK);
	}

	@GetMapping("/{sensorSerialId}")
	public ResponseEntity<Sensor> getSensorById(@PathVariable("sensorSerialId") Long sensorSerialId)
			throws CoreException {
		Sensor sensor = sensorService.getSensorById(sensorSerialId);
		return new ResponseEntity<>(sensor, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Response> updateSensorById(@RequestBody Sensor sensor) throws CoreException {
		Response response = sensorService.updateSensor(sensor);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{sensorSerialId}")
	public ResponseEntity<Response> deleteSensorById(@PathVariable("sensorSerialId") Long sensorSerialId)
			throws CoreException {
		Response response = sensorService.deleteSensor(sensorSerialId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
