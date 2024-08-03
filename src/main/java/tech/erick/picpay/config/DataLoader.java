package tech.erick.picpay.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import tech.erick.picpay.module.wallet.entity.WalletTypeEntity;
import tech.erick.picpay.module.wallet.repositories.WalletTypeRepository;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final WalletTypeRepository walletTypeRepository;

    public DataLoader(WalletTypeRepository walletTypeRepository){
        this.walletTypeRepository = walletTypeRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(WalletTypeEntity.Enum.values())
                .forEach(walletType ->walletTypeRepository.save(walletType.get()));
    }
}
