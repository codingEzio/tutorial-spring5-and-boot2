package io.datajek.spring.basics.rest01.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

@ControllerAdvice
public class PlayerExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<PlayerErrorResponse> playerNotFoundHandler(
			PlayerNotFoundException exception,
			HttpServletRequest request
	) {
		PlayerErrorResponse errorResponse = new PlayerErrorResponse(
				ZonedDateTime.now(),
				HttpStatus.NOT_FOUND.value(),
				request.getRequestURI(),
				exception.getMessage()
		);

		return new ResponseEntity<>(
				errorResponse,
				HttpStatus.NOT_FOUND
		);
	}
}