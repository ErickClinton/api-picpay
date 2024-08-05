package tech.erick.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAllowedForWalletTypeException extends PicPayException {
    @Override
    public ProblemDetail toProblemDetail() {
        var error = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        error.setTitle("Transfer not allowed for the wallet type");

        return error;
    }
}
