package tech.erick.picpay.module.tansfer;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.erick.picpay.module.tansfer.dto.TransferDto;
import tech.erick.picpay.module.tansfer.entity.TransferEntity;

@RestController
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransferEntity> transfer(@RequestBody @Valid TransferDto transferDto){
        var resp = transferService.transfer(transferDto);

        return ResponseEntity.ok(resp);
    }
}
