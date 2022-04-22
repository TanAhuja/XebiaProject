/**
 * Filename    : Plot.java
 * Version     : 1.0.0
 * Create Date : 21 Apr 2022
 *
 * © Example
 */
package com.example.models;

import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Plot {
	
	@NonNull
	private Long plotSerialId;

	@NonNull
	private Long length;

	@NonNull
	private Long breadth;
	
	@NonNull
	private Integer unitType;

	@NonNull
	private Double latitude;

	@NonNull
	private Double longitude;

	@NonNull
	private Integer soilType;

}
