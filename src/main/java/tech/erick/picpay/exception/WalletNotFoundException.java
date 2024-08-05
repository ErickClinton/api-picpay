package tech.erick.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletNotFoundException extends PicPayException{

    private Long walletId;

    public WalletNotFoundException(Long walletId){
        this.walletId = walletId;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var error = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        error.setTitle("Wallet not found");
        error.setDetail("There is no wallet with id "+ walletId );

        return error;
    }

}
