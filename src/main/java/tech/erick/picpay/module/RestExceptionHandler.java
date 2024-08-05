package tech.erick.picpay.module;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.erick.picpay.exception.PicPayException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PicPayException.class)
    public ProblemDetail handlePicPayException(PicPayException error){
        return error.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException error){

        var fieldErrors = error.getFieldErrors()
                .stream()
                .map(f -> new InvalidParam(f.getField(),f.getDefaultMessage()));

        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Your request paramets didn't validate.");
        problemDetail.setProperty("invalid-params",fieldErrors);

        return problemDetail;
    }

    private record InvalidParam(String name, String reason){};
}
