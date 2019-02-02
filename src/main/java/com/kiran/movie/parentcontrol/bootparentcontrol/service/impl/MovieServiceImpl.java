package com.kiran.movie.parentcontrol.bootparentcontrol.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import com.kiran.movie.parentcontrol.bootparentcontrol.exception.TechnicalFailureException;
import com.kiran.movie.parentcontrol.bootparentcontrol.exception.TitleNotFoundException;
import com.kiran.movie.parentcontrol.bootparentcontrol.model.ParentControlLevels;
import com.kiran.movie.parentcontrol.bootparentcontrol.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	private static List<Movie> movieList;
	private Movie selectedMovie;
	
	@Override
	public ParentControlLevels getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException {
		
		ParentControlLevels level = null;
		
		try {
			//empty the movie.
			this.setSelectedMovie(null);
			//check if the movieId exists.
			if(checkMovieTitleExists(movieId)) {
				if(null != this.getSelectedMovie()) {
					level = this.getSelectedMovie().getParentControlLevel();
				}
			} else {
				throw new TitleNotFoundException("Movie Title Not Found");
			}
		} catch (TechnicalFailureException exc) {
			throw new TechnicalFailureException("Technical Failure while fetching the movie details");
		}
		
		return level;
	}

	/**
	 * 
	 * @param movieId
	 * @return
	 * @throws TitleNotFoundException 
	 * @throws TechnicalFailureException 
	 */
	private boolean checkMovieTitleExists(String movieId) throws TitleNotFoundException, TechnicalFailureException {
		boolean exists = false;
		
		List<Movie> movieTempList = this.getMovieList();
		
		if(null != movieTempList) {
			for (ListIterator<Movie> iter = movieTempList.listIterator(); iter.hasNext();) {
				Movie movie = iter.next();
				if(movie.movieId.equals(movieId)) {
					this.setSelectedMovie(movie);
					exists = true;
					break;
				}
			}
		} else {
			throw new TechnicalFailureException("Technical Failure while fetching the movie details");
		}
		return exists;
	}

	/**
	 * @return the movieList, 
	 */
	public List<Movie> getMovieList() {
		
		if(null == movieList) {
			movieList = new ArrayList<Movie>();
		} 
		if (movieList.isEmpty()) {
			movieList.add(new Movie("001", "The Matrix", ParentControlLevels.A_12));
			movieList.add(new Movie("002", "Lost World - Jurrasic Park", ParentControlLevels.PG));
			movieList.add(new Movie("003", "Home Alone", ParentControlLevels.U));
			movieList.add(new Movie("004", "The Pirates Of Carrebian", ParentControlLevels.A_15));
			movieList.add(new Movie("005", "Zebra Crossing", ParentControlLevels.A_18));
			movieList.add(new Movie("006", "Tom and Jerry", ParentControlLevels.U));
		}
		return movieList;
	}

	/**
	 * @param movieList the movieList to set
	 */
	public void setMovieList(List<Movie> movieList) {
		MovieServiceImpl.movieList = movieList;
	}

	/**
	 * @return the selectedMovie
	 */
	public Movie getSelectedMovie() {
		return selectedMovie;
	}

	/**
	 * @param selectedMovie the selectedMovie to set
	 */
	public void setSelectedMovie(Movie selectedMovie) {
		this.selectedMovie = selectedMovie;
	}
}
