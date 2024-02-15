package it.epicode.blogging.exceptions;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResponseExceptionHandler {
  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public it.epicode.blogging.exceptions.ErrorResponse notFoundExceptionHandler(NotFoundException e) {
    return new ErrorResponse(e.getMessage());
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse ExceptionHandler(Exception e) {
    return new ErrorResponse(e.getMessage());
  }

  @ExceptionHandler(IOException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse IOExceptionHandler(Exception e) {
    return new ErrorResponse(e.getMessage());
  }

}
