/**
 * Filename    : PlotEntity.java
 * Version     : 1.0.0
 * Create Date : 21 Apr 2022
 *
 * © Example
 */
package com.example.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "Plot")
@EqualsAndHashCode(callSuper=false)
@Data
public class PlotEntity extends AbstractEntity {
	
	@Column(name = "Plot_Serial_Id", unique = true)
	private Long plotSerialId;
	
	@Column(name = "Length")
	private Long length;
	
	@Column(name = "Breadth")
	private Long breadth;
	
	@Column(name = "Unit_Type")
	private Integer unitType;
	
	@Column(name = "Latitude")
	private Double latitude;
	
	@Column(name = "Longitude")
	private Double longitude;
	
	@Column(name = "Soil_Type")
	private Integer soilType;
	
	@OneToMany(mappedBy = "plot")
	private Set<SensorEntity> sensors;

}
