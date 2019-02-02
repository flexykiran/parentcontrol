package com.kiran.movie.parentcontrol.bootparentcontrol.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.kiran.movie.parentcontrol.bootparentcontrol.exception.TechnicalFailureException;
import com.kiran.movie.parentcontrol.bootparentcontrol.exception.TitleNotFoundException;
import com.kiran.movie.parentcontrol.bootparentcontrol.model.ParentControlLevels;
import com.kiran.movie.parentcontrol.bootparentcontrol.service.MovieService;
import com.kiran.movie.parentcontrol.bootparentcontrol.service.ParentControlService;

@RunWith(MockitoJUnitRunner.class)
public class ParentControlServiceImplTest {

	@InjectMocks
	ParentControlServiceImpl pcsImpl = new ParentControlServiceImpl();

	@InjectMocks
	MovieServiceImpl movieServiceImpl = new MovieServiceImpl();
	
	@Mock
	ParentControlService parentControlService;
	
	@Mock
	MovieService movieService;

	@Test
	public void testCanWatchPG() throws TitleNotFoundException, TechnicalFailureException {
		
		String movieId = "002";
		ParentControlLevels level = ParentControlLevels.A_18;
		when(movieService.getParentalControlLevel(movieId)).thenReturn(ParentControlLevels.PG);
		
		assertEquals(true, pcsImpl.canWatchMovie(level, movieId));
	}
	
	@Test
	public void testCanChildWatchZerbaCrossingMovie() throws TitleNotFoundException, TechnicalFailureException {
		
		String movieId = "005";
		ParentControlLevels level = ParentControlLevels.U;
		when(movieService.getParentalControlLevel(movieId)).thenReturn(ParentControlLevels.A_18);
		
		pcsImpl.canWatchMovie(level, movieId);
	}
}
