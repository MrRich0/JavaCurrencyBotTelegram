package org.example;

import org.example.ParseMono.MONOCurrencyRateService;
import org.example.ParseNBY.NBYCurrencyRateService;
import org.example.ParsePrivat.PrivatCurrencyRateService;
import org.example.bank.Bank;
import org.example.ui.PrettyPrintCurrencyService;


public class BotLogic {
    static   CurrencyRateApiService apiNBY = new NBYCurrencyRateService();
    static   CurrencyRateApiService apiMONO = new MONOCurrencyRateService();
    static   CurrencyRateApiService apiPRIVAT = new PrivatCurrencyRateService();

    public static Bank bankChoice=Bank.ПриватБанк;
    public static int parseChose=2;

    public static String getChosenCurrency() {
        return String.valueOf(chosenCurrency);
    }

    public static Currency chosenCurrency= TelegramCurrencyBot.defaultCurrency;
    // інформація валюти


    public static String bankMenuButton(String tmp){
        String message="";


            switch (tmp){

                case "НБУ": bankChoice=Bank.НБУ;
                    message="НБУ";
                    break;
                case "МоноБанк":bankChoice=Bank.Монобанк;
                    message="МоноБанк";
                    break;
                case "ПриватБанк":
                    bankChoice=Bank.ПриватБанк;
                    message="ПриватБанк";
                    break;

            }
        return message;
    }
    public static RateResponceDto Curracy(String temp){
        RateResponceDto currencyInfo = null;
        switch (temp ) {
            case "USD":
                switch (bankChoice){
                    case НБУ:
                        currencyInfo=apiNBY.getRates(parseChose).get(0);
                        chosenCurrency=Currency.USD;
                        break;

                    case Монобанк:
                        currencyInfo= apiMONO.getRates(parseChose).get(0);
                        chosenCurrency=Currency.USD;
                        break;
                    case ПриватБанк:
                        currencyInfo=  apiPRIVAT.getRates(parseChose).get(1);
                        chosenCurrency=Currency.USD;
                        break;
                }
                break;
            case "EUR":
                switch (bankChoice){
                    case НБУ: currencyInfo=apiNBY.getRates(parseChose).get(1);
                        chosenCurrency=Currency.EUR;
                        break;
                    case Монобанк:
                        currencyInfo= apiMONO.getRates(parseChose).get(1);
                        chosenCurrency=Currency.EUR;
                        break;
                    case ПриватБанк:
                        currencyInfo=apiPRIVAT.getRates(parseChose).get(0);
                        chosenCurrency=Currency.EUR;
                        break;
                }
                break;
            default:
                System.out.println("На жаль валюти " + chosenCurrency +" немає!Спробуйте ще раз.");
        }
        return currencyInfo;
    }

    public static String parseMenuButton(String chose ){

String parseMessage="";

            switch (chose){
                case "2": parseChose=2;
                    parseMessage= String.valueOf(parseChose);

                    break;
                case "3":parseChose=3;
                    parseMessage= String.valueOf(parseChose);

                    break;
                case "4":parseChose=4;
                    parseMessage= String.valueOf(parseChose);

                    break;

            }

   return parseMessage; }

    public static String getFinalMessage() {
        PrettyPrintCurrencyService prettyPrintCurrencyService=new PrettyPrintCurrencyService();
        RateResponceDto currencyInfo=Curracy(String.valueOf(chosenCurrency));

        return prettyPrintCurrencyService.convert(String.valueOf(currencyInfo.getRateBuy()),String.valueOf(currencyInfo.getRateSell()),String.valueOf(bankChoice),String.valueOf(chosenCurrency)) ;
    }
}

