package com.iplteam.IPL_CURD_SERVER;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.iplteam.IPL_CURD_SERVER.player.PlayerNotFoundException;
import com.iplteam.IPL_CURD_SERVER.team.TeamNotFoundException;

@ControllerAdvice
public class ControllerExceptionalHandler {

		private final Logger logger = LoggerFactory.getLogger(getClass());
		@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The player was not found in the system")
	    @ExceptionHandler(PlayerNotFoundException.class)
	    public void playerNotFoundExceptionHandler(Exception exception) {
	        logger.warn(exception.getMessage());
	    }
		
		 @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The team was not found in the system")
		    @ExceptionHandler(TeamNotFoundException.class)
		    public void teamNotFoundExceptionHandler(Exception exception) {
		        logger.warn(exception.getMessage());
		    }

}
