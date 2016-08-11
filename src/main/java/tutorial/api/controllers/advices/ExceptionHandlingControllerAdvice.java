package tutorial.api.controllers.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.ArrayList;

@ControllerAdvice
public class ExceptionHandlingControllerAdvice {

    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public void error(ConstraintViolationException exception,
                      HttpServletResponse response) throws IOException {
        ArrayList<String> messages = new ArrayList<>();

        for (ConstraintViolation violation : exception.getConstraintViolations()) {
            messages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
    }
    response.sendError(HttpStatus.BAD_REQUEST.value(), String.join(", ", messages));
    }

}
