package org.example.ParseMono;

import org.example.Currency;

import java.math.BigDecimal;

public class MONOCurrencyResponceDto {
    private Integer currencyCodeA;
    private Integer currencyCodeB;
    private BigDecimal rateBuy;
    private BigDecimal rateSell;

    private Currency currencyBuy;
    private Currency currencySell;

    public Integer getCurrencyCodeA() {
        return currencyCodeA;
    }

    public void setCurrencyCodeA(Integer currencyCodeA) {
        this.currencyCodeA = currencyCodeA;
    }

    public Integer getCurrencyCodeB() {
        return currencyCodeB;
    }

    public void setCurrencyCodeB(Integer currencyCodeB) {
        this.currencyCodeB = currencyCodeB;
    }

    public BigDecimal getRateBuy() {
        return rateBuy;
    }

    public void setRateBuy(BigDecimal rateBuy) {
        this.rateBuy = rateBuy;
    }

    public BigDecimal getRateSell() {
        return rateSell;
    }

    public void setRateSell(BigDecimal rateSell) {
        this.rateSell = rateSell;
    }

    public Currency getCurrencyBuy() {
        return currencyBuy;
    }

    public void setCurrencyBuy(Currency currencyBuy) {
        this.currencyBuy = currencyBuy;
    }

    public Currency getCurrencySell() {
        return currencySell;
    }

    public void setCurrencySell(Currency currencySell) {
        this.currencySell = currencySell;
    }

    @Override
    public String toString() {
        return
                "currencyCodeA=" + currencyCodeA +
                ", currencyCodeB=" + currencyCodeB +
                ", rateBuy=" + rateBuy +
                ", rateSell=" + rateSell +
                ", currencyBuy='" + currencyBuy + '\'' +
                ", currencySell='" + currencySell + '\'';
    }
}
