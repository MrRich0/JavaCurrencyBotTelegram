package org.example.ui;

import org.example.Currency;
//import org.example.bank.Bank;

import java.math.BigDecimal;

public class PrettyPrintCurrencyService {
    public String convert(String buy, String sale, String bank, String currency){
        String temp = "Курс у ${bank}: ${currency}/ UAH \nКупівля: ${buy} \nПродаж: ${sale}";
        return temp.replace("${bank}", bank)
                .replace("${currency}", currency)
                .replace("${buy}", buy)
                .replace("${sale}", sale);
    }
}
