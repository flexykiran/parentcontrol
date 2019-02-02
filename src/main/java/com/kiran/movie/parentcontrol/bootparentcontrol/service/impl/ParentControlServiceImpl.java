package com.kiran.movie.parentcontrol.bootparentcontrol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.kiran.movie.parentcontrol.bootparentcontrol.exception.TechnicalFailureException;
import com.kiran.movie.parentcontrol.bootparentcontrol.exception.TitleNotFoundException;
import com.kiran.movie.parentcontrol.bootparentcontrol.model.ParentControlLevels;
import com.kiran.movie.parentcontrol.bootparentcontrol.service.MovieService;
import com.kiran.movie.parentcontrol.bootparentcontrol.service.ParentControlService;

public class ParentControlServiceImpl implements ParentControlService {

	@Autowired
	MovieService movieService;
	
	@Override
	public boolean canWatchMovie(ParentControlLevels level, String movieId) throws TitleNotFoundException, TechnicalFailureException {
		boolean canWatch = false;
		try {
			ParentControlLevels pLevel = movieService.getParentalControlLevel(movieId);
			
			if(null != pLevel && pLevel.level() <= level.level()) {
				canWatch = true;
			}
		} catch (TitleNotFoundException | TechnicalFailureException e) {
			if(e instanceof TitleNotFoundException) {
				throw new TitleNotFoundException(e.getMessage());
			} else {
				throw new TechnicalFailureException(e.getMessage());
			}
		}
		return canWatch;
	}
}
