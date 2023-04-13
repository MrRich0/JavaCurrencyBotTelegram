package org.example.ParseNBY;

import org.example.Currency;

import java.math.BigDecimal;

public class NBYCurrencyResponceDto {
    private Integer r030;
    private  String txt;
    private BigDecimal rate;
    private Currency cc;
    private String exchangedate;

    private Currency currencyTo = Currency.UAH;



    public void setR030(int r030) {
        this.r030 = r030;
    }
    public void setTxt(String txt) {
        this.txt = txt;
    }
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
    public void setCc(Currency cc) {
        this.cc = cc;
    }
    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }


    public int getR030() {
        return r030;
    }
    public String getTxt() {
        return txt;
    }
    public BigDecimal getRate() {
        return rate;
    }
    public Currency getCc() {
        return cc;
    }
    public String getExchangedate() {
        return exchangedate;
    }

    public Currency getCurrencyTo() {
        return currencyTo;
    }

    @Override
    public String toString() {
        return "NBYCurrencyResponceDto{" +
                "r030=" + r030 +
                ", txt='" + txt + '\'' +
                ", rate=" + rate +
                ", cc=" + cc +
                ", exchangedate=" + exchangedate +
                '}';
    }
}


