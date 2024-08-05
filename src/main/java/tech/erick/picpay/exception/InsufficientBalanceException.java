package tech.erick.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InsufficientBalanceException extends PicPayException{
    @Override
    public ProblemDetail toProblemDetail() {
        var error = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        error.setTitle("Insufficient balance");
        error.setDetail("You cannot transfer a value bigger than your current balance.");

        return error;
    }
}
