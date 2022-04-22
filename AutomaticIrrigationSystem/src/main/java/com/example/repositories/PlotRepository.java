/**
 * Filename    : PlotRepository.java
 * Version     : 1.0.0
 * Create Date : 21 Apr 2022
 *
 * © Example
 */
package com.example.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.PlotEntity;

@Repository
public interface PlotRepository extends JpaRepository<PlotEntity, Long>{
	
	/**
	 * This method find plot details by plotSerialId
	 * 
	 * @param plotSerialId
	 * @return
	 */
	Optional<PlotEntity> findByPlotSerialId(Long plotSerialId);

}
