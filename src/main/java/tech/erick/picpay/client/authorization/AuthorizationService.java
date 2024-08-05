package tech.erick.picpay.client.authorization;

import org.springframework.stereotype.Service;
import tech.erick.picpay.exception.PicPayException;
import tech.erick.picpay.module.tansfer.dto.TransferDto;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient){
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDto transferEntity){
        var resp = authorizationClient.isAuthorized();
        if(resp.getStatusCode().isError()) throw new PicPayException();

        return resp.getBody().authorized();
    }

}
