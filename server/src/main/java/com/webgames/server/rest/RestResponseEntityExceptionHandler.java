package com.webgames.server.rest;

import com.webgames.server.game.hangman.GameSessionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler({ GameSessionException.class })
    public ResponseEntity<Object> handleInvalidRequestException(Exception ex, WebRequest request)
    {
        return new ResponseEntity<Object>("Invalid request!", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
