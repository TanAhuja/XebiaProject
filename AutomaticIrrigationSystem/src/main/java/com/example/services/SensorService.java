/**
 * Filename    : SensorService.java
 * Version     : 1.0.0
 * Create Date : 21 Apr 2022
 *
 * © Example
 */
package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.SensorEntity;
import com.example.exception.CoreException;
import com.example.models.Response;
import com.example.models.Sensor;
import com.example.repositories.SensorRepository;
import com.example.utils.Constants;

@Service
public class SensorService {

	@Autowired
	SensorRepository sensorRepository;

	Logger logger = LoggerFactory.getLogger(SensorService.class);

	/**
	 * This method add new Sensor in the system
	 * 
	 * @param Sensor
	 * @return
	 * @throws CoreException
	 */
	public Response createSensor(Sensor Sensor) throws CoreException {
		logger.debug("Create Sensor: {}", Sensor);
		Response response = new Response();
		try {
			SensorEntity SensorEntity = new SensorEntity();
			BeanUtils.copyProperties(Sensor, SensorEntity);
			sensorRepository.save(SensorEntity);
			response.setResponseCode(Constants.SUC_SENSOR_CREATE);
			response.setResponseMessage(Constants.SUC_SENSOR_CREATE_MSG);
		} catch (Exception e) {
			logger.error("Error while creating Sensor details : {}", Sensor);
			throw new CoreException(null, null, null);
		}
		return response;
	}

	/**
	 * This method gets all Sensors details
	 * 
	 * @return
	 * @throws CoreException
	 */
	public List<Sensor> getAllSensors() throws CoreException {
		List<Sensor> Sensors = new ArrayList<>();
		try {
			List<SensorEntity> SensorEntities = sensorRepository.findAll();
			SensorEntities.forEach(SensorEntity -> {
				Sensor Sensor = new Sensor();
				BeanUtils.copyProperties(SensorEntity, Sensor);
				Sensors.add(Sensor);
			});
		} catch (Exception e) {
			logger.error("Error while getting all Sensor details");
			throw new CoreException(null, null, null);
		}
		return Sensors;
	}

	/**
	 * This method get Sensor details by Id
	 * 
	 * @param sensorSerialId
	 * @return
	 * @throws CoreException
	 */
	public Sensor getSensorById(Long sensorSerialId) throws CoreException {
		Sensor Sensor = new Sensor();
		try {
			SensorEntity SensorEntity = sensorRepository.findBySensorSerialId(sensorSerialId)
					.orElseThrow(() -> new CoreException(null, null, null));
			BeanUtils.copyProperties(SensorEntity, Sensor);
		} catch (Exception e) {
			logger.error("Error while getting Sensor details for: {}", sensorSerialId);
			throw new CoreException(null, null, null);
		}
		return Sensor;
	}

	/**
	 * This method updates Sensor details
	 * 
	 * @param Sensor
	 * @return
	 * @throws CoreException
	 */
	public Response updateSensor(Sensor Sensor) throws CoreException {
		Response response = new Response();
		try {
			SensorEntity SensorEntity = sensorRepository.findBySensorSerialId(Sensor.getSensorSerialId())
					.orElseThrow(() -> new CoreException(null, null, null));
			BeanUtils.copyProperties(Sensor, SensorEntity);
			sensorRepository.save(SensorEntity);
			response.setResponseCode(Constants.SUC_SENSOR_UPDATE);
			response.setResponseMessage(Constants.SUC_SENSOR_UPDATE_MSG);
		} catch (Exception e) {
			logger.error("Error while updating Sensor details for: {}", Sensor);
			throw new CoreException(null, null, null);
		}
		return response;
	}

	/**
	 * This method deletes Sensor detail
	 * 
	 * @param sensorSerialId
	 * @return
	 * @throws CoreException
	 */
	public Response deleteSensor(Long sensorSerialId) throws CoreException {
		Response response = new Response();
		try {
			SensorEntity SensorEntity = sensorRepository.findBySensorSerialId(sensorSerialId)
					.orElseThrow(() -> new CoreException(null, null, null));
			sensorRepository.delete(SensorEntity);
			response.setResponseCode(Constants.SUC_SENSOR_DELETE);
			response.setResponseMessage(Constants.SUC_SENSOR_DELETE_MSG);
		} catch (Exception e) {
			logger.error("Error while deleting Sensor details for: {}", sensorSerialId);
			throw new CoreException(null, null, null);
		}
		return response;
	}

}
