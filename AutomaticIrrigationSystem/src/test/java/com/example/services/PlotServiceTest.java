/**
 * Filename    : PlotServiceTest.java
 * Version     : 1.0.0
 * Create Date : 22 Apr 2022
 *
 * © Example
 */
package com.example.services;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.entities.PlotEntity;
import com.example.exception.CoreException;
import com.example.models.Response;
import com.example.repositories.PlotRepository;
import com.example.samples.MockSamples;
import com.example.utils.Constants;

public class PlotServiceTest {

	@InjectMocks
	PlotService plotService;

	@Mock
	PlotRepository plotRepository;

	@BeforeEach
	public void setupMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreatePlot() throws Throwable {
		when(plotRepository.save(Mockito.any(PlotEntity.class))).thenReturn(MockSamples.plotEntity);
		Response res = plotService.createPlot(MockSamples.plot);
		assertEquals(Constants.SUC_PLOT_CREATE, res.getResponseCode());
	}

	@Test
	public void testGetPlotByIdException() throws Throwable {
		when(plotRepository.findByPlotSerialId(Mockito.anyLong())).thenReturn(Optional.empty());
		assertThatExceptionOfType(CoreException.class).isThrownBy(() -> plotService.getPlotById(1L))
				.matches(e -> e.getErrorCode().equalsIgnoreCase(Constants.ERR_PLOT_GET));
	}

}
