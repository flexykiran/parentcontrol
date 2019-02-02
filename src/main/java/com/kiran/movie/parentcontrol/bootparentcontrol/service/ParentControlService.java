package com.kiran.movie.parentcontrol.bootparentcontrol.service;

import com.kiran.movie.parentcontrol.bootparentcontrol.exception.TechnicalFailureException;
import com.kiran.movie.parentcontrol.bootparentcontrol.exception.TitleNotFoundException;
import com.kiran.movie.parentcontrol.bootparentcontrol.model.ParentControlLevels;

public interface ParentControlService {

	boolean canWatchMovie(ParentControlLevels level, String movieId) throws TitleNotFoundException, TechnicalFailureException;
}
