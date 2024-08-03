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

    public WalletTypeEntity(Long id, String description) {
        this.id = id;
        this.description = description;
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

    public enum Enum{

        USER(1L,"user"),
        MERCHANT(2L,"merchant");
        Enum(long id, String description) {
            this.id = id;
            this.description = description;
        }

        private final Long id;
        private final String description;

        public WalletTypeEntity get(){
            return new WalletTypeEntity(id,description);
        }
    }

}
