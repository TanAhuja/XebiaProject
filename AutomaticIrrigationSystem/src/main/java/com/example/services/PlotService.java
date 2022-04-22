/**
 * Filename    : PlotService.java
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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.entities.PlotEntity;
import com.example.exception.CoreException;
import com.example.models.Plot;
import com.example.models.Response;
import com.example.repositories.PlotRepository;
import com.example.utils.Constants;

@Service
public class PlotService {

	@Autowired
	PlotRepository plotRepository;

	Logger logger = LoggerFactory.getLogger(PlotService.class);

	/**
	 * This method add new plot in the system
	 * 
	 * @param plot
	 * @return
	 * @throws CoreException
	 */
	public Response createPlot(Plot plot) throws CoreException {
		logger.debug("Create Plot: {}", plot);
		Response response = new Response();
		try {
			PlotEntity plotEntity = new PlotEntity();
			BeanUtils.copyProperties(plot, plotEntity);
			plotRepository.save(plotEntity);
			response.setResponseCode(Constants.SUC_PLOT_CREATE);
			response.setResponseMessage(Constants.SUC_PLOT_CREATE_MSG);
		} catch (Exception e) {
			logger.error("Error while creating plot details : {}", plot);
			throw new CoreException(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	/**
	 * This method gets all plots details
	 * 
	 * @return
	 * @throws CoreException
	 */
	public List<Plot> getAllPlots() throws CoreException {
		List<Plot> plots = new ArrayList<>();
		try {
			List<PlotEntity> plotEntities = plotRepository.findAll();
			plotEntities.forEach(plotEntity -> {
				Plot plot = new Plot();
				BeanUtils.copyProperties(plotEntity, plot);
				plots.add(plot);
			});
		} catch (Exception e) {
			logger.error("Error while getting all plot details");
			throw new CoreException(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return plots;
	}

	/**
	 * This method get plot details by Id
	 * 
	 * @param plotSerialId
	 * @return
	 * @throws CoreException
	 */
	public Plot getPlotById(Long plotSerialId) throws CoreException {
		Plot plot = new Plot();
		try {
			PlotEntity plotEntity = plotRepository.findByPlotSerialId(plotSerialId)
					.orElseThrow(() -> new CoreException(Constants.ERR_PLOT_GET, null, HttpStatus.BAD_REQUEST));
			BeanUtils.copyProperties(plotEntity, plot);
		} catch (CoreException e) {
			logger.error("No such plot detail found for: {}", plotSerialId);
			throw e;
		} catch (Exception e) {
			logger.error("Error while getting plot details for: {}", plotSerialId);
			throw new CoreException(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return plot;
	}

	/**
	 * This method updates plot details
	 * 
	 * @param plot
	 * @return
	 * @throws CoreException
	 */
	public Response updatePlot(Plot plot) throws CoreException {
		Response response = new Response();
		try {
			PlotEntity plotEntity = plotRepository.findByPlotSerialId(plot.getPlotSerialId())
					.orElseThrow(() -> new CoreException(null, null, HttpStatus.BAD_REQUEST));
			BeanUtils.copyProperties(plot, plotEntity);
			plotRepository.save(plotEntity);
			response.setResponseCode(Constants.SUC_PLOT_UPDATE);
			response.setResponseMessage(Constants.SUC_PLOT_UPDATE_MSG);
		} catch (Exception e) {
			logger.error("Error while updating plot details for: {}", plot);
			throw new CoreException(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	/**
	 * This method deletes plot detail
	 * 
	 * @param plotSerialId
	 * @return
	 * @throws CoreException
	 */
	public Response deletePlot(Long plotSerialId) throws CoreException {
		Response response = new Response();
		try {
			PlotEntity plotEntity = plotRepository.findByPlotSerialId(plotSerialId)
					.orElseThrow(() -> new CoreException(null, null, HttpStatus.BAD_REQUEST));
			plotRepository.delete(plotEntity);
			response.setResponseCode(Constants.SUC_PLOT_DELETE);
			response.setResponseMessage(Constants.SUC_PLOT_DELETE_MSG);
		} catch (Exception e) {
			logger.error("Error while deleting plot details for: {}", plotSerialId);
			throw new CoreException(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
