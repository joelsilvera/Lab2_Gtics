package com.example.lab2_gtics.entity;

import javax.persistence.*;

@Entity
@Table(name = "wallet_has_currency")
public class WalletHasCurrency {
    @EmbeddedId
    private WalletHasCurrencyId id;

    @MapsId("walletIdwallet")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "wallet_idwallet", nullable = false)
    private Wallet walletIdwallet;

    @MapsId("currencyIdcurrency")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "currency_idcurrency", nullable = false)
    private Currency currencyIdcurrency;

    @Column(name = "purchase_price")
    private Double purchasePrice;

    @Column(name = "amount")
    private Double amount;

    public WalletHasCurrencyId getId() {
        return id;
    }

    public void setId(WalletHasCurrencyId id) {
        this.id = id;
    }

    public Wallet getWalletIdwallet() {
        return walletIdwallet;
    }

    public void setWalletIdwallet(Wallet walletIdwallet) {
        this.walletIdwallet = walletIdwallet;
    }

    public Currency getCurrencyIdcurrency() {
        return currencyIdcurrency;
    }

    public void setCurrencyIdcurrency(Currency currencyIdcurrency) {
        this.currencyIdcurrency = currencyIdcurrency;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}