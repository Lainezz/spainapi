package com.es.spainapi.error;

import com.es.spainapi.error.exception.BadRequestException;
import com.es.spainapi.error.exception.DuplicateException;
import com.es.spainapi.error.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler({BadRequestException.class, DuplicateException.class, IllegalArgumentException.class, IllegalStateException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ClientErrorMessage handleBadRequest(HttpServletRequest request, Exception ex) {
        return new ClientErrorMessage(ex.getMessage(), request.getRequestURI(), request.getMethod(), HttpStatus.BAD_REQUEST.value());
    }


    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ClientErrorMessage handleNotFound(HttpServletRequest request, Exception ex) {
        return new ClientErrorMessage(ex.getMessage(), request.getRequestURI(), request.getMethod(), HttpStatus.BAD_REQUEST.value());
    }
}
