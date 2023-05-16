package edu.uoc.abarrena.users.infrastructure.rest.handler;

import edu.uoc.abarrena.users.domain.exceptions.AbstractBusinessLogicException;
import edu.uoc.abarrena.users.infrastructure.rest.dto.response.Result;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class BussinessLogicExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(AbstractBusinessLogicException.class)
    public Result<String> businessLogicException(AbstractBusinessLogicException ex) {
        String message = ex.getMessage();

        return new Result<>(message);
    }
}
