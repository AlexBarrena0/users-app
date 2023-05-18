package edu.uoc.abarrena.users.application.handler;

import edu.uoc.abarrena.users.domain.exceptions.EntityNotFoundException;
import edu.uoc.abarrena.users.application.dto.response.Result;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class NotFoundExceptionHandler {

    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    public Result<String> notFoundException(EntityNotFoundException ex) {
        String message = ex.getMessage();

        return new Result<>(message);
    }
}
