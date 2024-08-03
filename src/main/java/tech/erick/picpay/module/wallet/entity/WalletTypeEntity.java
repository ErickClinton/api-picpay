package tech.erick.picpay.module.wallet.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "wallet_type")
public class WalletTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public WalletTypeEntity(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
