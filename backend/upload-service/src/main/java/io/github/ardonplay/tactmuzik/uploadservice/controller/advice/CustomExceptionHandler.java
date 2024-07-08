package io.github.ardonplay.tactmuzik.uploadservice.controller.advice;

import io.github.ardonplay.tactmuzik.uploadservice.exception.file.UnsupportedFileTypeException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UnsupportedFileTypeException.class)
    @ResponseBody
    public String handleUnsupportedFileTypeException(UnsupportedFileTypeException exception) {
        log.info("Handling unsupported file type exception: {}", exception.getMessage());
        return exception.getMessage();
    }
}
