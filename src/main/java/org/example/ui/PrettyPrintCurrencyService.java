package org.example.ui;

import org.example.bank.Bank;

import java.math.BigDecimal;
import java.util.Currency;

public class PrettyPrintCurrencyService {
    public String convert(BigDecimal buy, BigDecimal sale, Bank bank, Currency currency){
        String temp = "Курс у ${bank}: ${currency}/ UAH \n Купівля: ${buy} \n Продаж: ${sale}";
        return temp;
               /* .replace("${bank}", bank.name())
                .replace("${currency}", currency)
                .replace("${buy}", buy)
                .replace("${sale}", sale);*/
    }
}
