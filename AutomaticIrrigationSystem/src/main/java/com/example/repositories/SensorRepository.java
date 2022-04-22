/**
 * Filename    : SensorRepository.java
 * Version     : 1.0.0
 * Create Date : 21 Apr 2022
 *
 * © Example
 */
package com.example.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.SensorEntity;

@Repository
public interface SensorRepository extends JpaRepository<SensorEntity, Long> {

	/**
	 * This method find sensor details by sensorSerialId
	 * 
	 * @param sensorSerialId
	 * @return
	 */
	Optional<SensorEntity> findBySensorSerialId(Long sensorSerialId);

}
