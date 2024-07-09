package io.github.ardonplay.tactmuzik.streamingservice.controller.advice;

import io.github.ardonplay.tactmuzik.streamingservice.exception.BaseErrorInfo;
import io.github.ardonplay.tactmuzik.streamingservice.exception.ObjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebExchange;

@Slf4j
@Order(-2)
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(ObjectNotFoundException.class)
  public BaseErrorInfo handleNotFound(ServerWebExchange exchange, Exception ex) {
    log.warn(ex.getMessage());
    return new BaseErrorInfo(HttpStatus.NOT_FOUND.value(),
        exchange.getRequest().getPath().toString(), ex.getMessage());
  }
}