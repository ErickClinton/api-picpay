package tech.erick.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletDataAlreadyExistsException extends PicPayException{

    private final String detail;

    public WalletDataAlreadyExistsException(String detail){
        this.detail = detail;
    }
    @Override
    public ProblemDetail toProblemDetail() {
        var error = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        error.setTitle("Wallet data already exists");
        error.setDetail(detail);
        return error;
    }
}
