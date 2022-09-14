package com.example.lab2_gtics.entity;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @Column(name = "idtransaction", nullable = false)
    private Integer id;

    @Column(name = "description", length = 45)
    private String description;

    @Column(name = "tx_id", nullable = false, length = 80)
    private String txId;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "network_fee", nullable = false)
    private Double networkFee;

    @Column(name = "block", nullable = false)
    private Integer block;

    @Column(name = "status", nullable = false, length = 45)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_iduser", nullable = false)
    private User userIduser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "wallet_idwallet", nullable = false)
    private Wallet walletIdwallet;

    @Column(name = "currency", nullable = false, length = 45)
    private String currency;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getNetworkFee() {
        return networkFee;
    }

    public void setNetworkFee(Double networkFee) {
        this.networkFee = networkFee;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(User userIduser) {
        this.userIduser = userIduser;
    }

    public Wallet getWalletIdwallet() {
        return walletIdwallet;
    }

    public void setWalletIdwallet(Wallet walletIdwallet) {
        this.walletIdwallet = walletIdwallet;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}