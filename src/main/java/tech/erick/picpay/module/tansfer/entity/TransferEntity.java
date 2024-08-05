package tech.erick.picpay.module.tansfer.entity;

import jakarta.persistence.*;
import tech.erick.picpay.module.wallet.entity.WalletEntity;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="transfer")
public class TransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JoinColumn(name="wallet_sender_id")
    @ManyToOne
    private WalletEntity sender;

    @ManyToOne
    @JoinColumn(name="wallet_receiver_id")
    private WalletEntity receiver;

    @Column(name="value")
    private BigDecimal value;

    public TransferEntity(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public WalletEntity getSender() {
        return sender;
    }

    public void setSender(WalletEntity sender) {
        this.sender = sender;
    }

    public WalletEntity getReceiver() {
        return receiver;
    }

    public void setReceiver(WalletEntity receiver) {
        this.receiver = receiver;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
