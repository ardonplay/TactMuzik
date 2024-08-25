package io.github.ardonplay.metadataservice.controller.advice;


import io.github.ardonplay.metadataservice.exception.MetadataAlreadyExistsException;
import io.github.ardonplay.metadataservice.exception.MetadataNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomExceptionHandler {

  private static final Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);
  private static final String LOG_STRING_TEMPLATE = "{}: {}";

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(MetadataNotFoundException.class)
  @ResponseBody
  public ErrorResponse handleMetadataNotFoundException(MetadataNotFoundException exception) {
    log.info(LOG_STRING_TEMPLATE, exception.getClass(), exception.getMessage());
    return new ErrorResponse(exception.getMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MetadataAlreadyExistsException.class)
  @ResponseBody
  public ErrorResponse handleBoxNotFoundException(MetadataAlreadyExistsException exception) {
    log.info(LOG_STRING_TEMPLATE, exception.getClass(), exception.getMessage());
    return new ErrorResponse(exception.getMessage());
  }
}
