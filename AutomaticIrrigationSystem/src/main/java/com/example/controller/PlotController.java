/**
 * Filename    : PlotController.java
 * Version     : 1.0.0
 * Create Date : 21 Apr 2022
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
import com.example.models.Plot;
import com.example.models.Response;
import com.example.services.PlotService;

@RestController
@RequestMapping("/plots")
public class PlotController {

	@Autowired
	PlotService plotService;

	@PostMapping
	public ResponseEntity<Response> createPlot(@RequestBody Plot plot) throws CoreException {
		Response response = plotService.createPlot(plot);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Plot>> getAllPlots() throws CoreException {
		List<Plot> plots = plotService.getAllPlots();
		return new ResponseEntity<>(plots, HttpStatus.OK);
	}

	@GetMapping("/{plotSerialId}")
	public ResponseEntity<Plot> getPlotById(@PathVariable("plotSerialId") Long plotSerialId) throws CoreException {
		Plot plot = plotService.getPlotById(plotSerialId);
		return new ResponseEntity<>(plot, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Response> updatePlotById(@RequestBody Plot plot) throws CoreException {
		Response response = plotService.updatePlot(plot);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{plotSerialId}")
	public ResponseEntity<Response> deletePlotById(@PathVariable("plotSerialId") Long plotSerialId)
			throws CoreException {
		Response response = plotService.deletePlot(plotSerialId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
