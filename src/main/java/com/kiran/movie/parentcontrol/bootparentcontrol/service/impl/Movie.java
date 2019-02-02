package com.kiran.movie.parentcontrol.bootparentcontrol.service.impl;

import com.kiran.movie.parentcontrol.bootparentcontrol.model.ParentControlLevels;

/**
 * 
 * @author flexykiran
 *
 */
public class Movie {

	String movieId;
	String movieName;
	ParentControlLevels parentControlLevel;
	
	public Movie(String movieId, String movieName, ParentControlLevels parentControlLevel) {
		this.setMovieId(movieId);
		this.setMovieName(movieName);
		this.setParentControlLevel(parentControlLevel);
	}
	
	/**
	 * @return the movieId
	 */
	public String getMovieId() {
		return movieId;
	}
	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}
	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	/**
	 * @return the parentControlLevel
	 */
	public ParentControlLevels getParentControlLevel() {
		return parentControlLevel;
	}
	/**
	 * @param parentControlLevel the parentControlLevel to set
	 */
	public void setParentControlLevel(ParentControlLevels parentControlLevel) {
		this.parentControlLevel = parentControlLevel;
	}
}
