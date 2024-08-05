package tech.erick.picpay.client.authorization;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import tech.erick.picpay.client.authorization.dto.AuthorizationResponseDto;

@FeignClient(
        name = "Authorization",
        url = "${client.authorization-service.url}"
)
public interface AuthorizationClient {

    @GetMapping
    ResponseEntity<AuthorizationResponseDto> isAuthorized();
}
