package tech.erick.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PicPayException extends RuntimeException{

    public ProblemDetail toProblemDetail(){
        var error = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        error.setTitle("PicPay Internal server error");

        return error;
    }
}
