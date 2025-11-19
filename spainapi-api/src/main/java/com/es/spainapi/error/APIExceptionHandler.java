package com.es.spainapi.error;

import com.es.spainapi.exception.BadRequestException;
import com.es.spainapi.exception.DuplicateException;
import com.es.spainapi.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.URI;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler({BadRequestException.class, DuplicateException.class, IllegalArgumentException.class, IllegalStateException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ProblemDetail handleBadRequest(HttpServletRequest request, Exception ex) {
	    return buildProblemDetail(request, ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ProblemDetail handleNotFound(HttpServletRequest request, Exception ex) {
		return buildProblemDetail(request, ex, HttpStatus.NOT_FOUND);
    }

	private ProblemDetail buildProblemDetail(HttpServletRequest request, Exception ex, HttpStatus status) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(status);
		problemDetail.setTitle(ex.getClass().getSimpleName());
		problemDetail.setDetail(ex.getMessage());
		problemDetail.setStatus(status);
		problemDetail.setType(URI.create(request.getRequestURL().toString()));
		problemDetail.setProperty("method", request.getMethod());
		return problemDetail;
	}
}
