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

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceImplTest {

	@InjectMocks
	MovieServiceImpl movieServiceImpl = new MovieServiceImpl();
	
	@Mock
	MovieService movieService;
	
	@Test
	public void testChildMovie() throws TitleNotFoundException, TechnicalFailureException {
		
		String movieId = "003";
		assertEquals(ParentControlLevels.U, movieServiceImpl.getParentalControlLevel(movieId));
	}
	
	@Test
	public void testAdultMovie() throws TitleNotFoundException, TechnicalFailureException {
		
		String movieId = "005";
		assertEquals(ParentControlLevels.A_18, movieServiceImpl.getParentalControlLevel(movieId));
	}
	
	@Test(expected = TitleNotFoundException.class)
	public void testMovieNotFoundException() throws TitleNotFoundException, TechnicalFailureException {
		
		String movieId = "009";
		assertEquals(ParentControlLevels.A_18, movieServiceImpl.getParentalControlLevel(movieId));
	}
	
	/*@Test(expected = TechnicalFailureException.class)
	public void testCanWatchTechnicalFailureException()
			throws TechnicalFailureException, TitleNotFoundException {
		//when(movieServiceImpl.getMovieList()).thenReturn(new TechnicalFailureException);
		when(movieServiceImpl.getMovieList()).thenThrow(TechnicalFailureException.class);
		assertEquals(ParentControlLevels.A_18, movieServiceImpl.getParentalControlLevel(null));
	}*/
}
