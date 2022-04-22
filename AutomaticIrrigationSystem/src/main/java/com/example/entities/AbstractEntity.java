/**
 * Filename    : AbstractEntity.java
 * Version     : 1.0.0
 * Create Date : 21 Apr 2022
 *
 * © Example
 */
package com.example.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

}
