package com.kiran.movie.parentcontrol.bootparentcontrol.service;

import com.kiran.movie.parentcontrol.bootparentcontrol.exception.TechnicalFailureException;
import com.kiran.movie.parentcontrol.bootparentcontrol.exception.TitleNotFoundException;
import com.kiran.movie.parentcontrol.bootparentcontrol.model.ParentControlLevels;

/**
 * 
 * @author flexykiran
 *
 */
public interface MovieService {

	ParentControlLevels getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException;
}
