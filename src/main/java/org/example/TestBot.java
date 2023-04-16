package org.example;

import org.example.ParseMono.MONOCurrencyRateService;
import org.example.ParseNBY.NBYCurrencyRateService;
import org.example.ParsePrivat.PrivatCurrencyRateService;
import org.example.bank.Bank;
import org.example.command.Buttons;
import org.example.ui.PrettyPrintCurrencyService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.io.IOException;
import java.util.Scanner;


public class TestBot {
    static   CurrencyRateApiService apiNBY = new NBYCurrencyRateService();
    static   CurrencyRateApiService apiMONO = new MONOCurrencyRateService();
    static   CurrencyRateApiService apiPRIVAT = new PrivatCurrencyRateService();
    static Message notification = new Message();

    static Scanner scanner = new Scanner(System.in);
    public static Bank bankChoice=Bank.ПриватБанк;
    public static int parseChose=2;

    public static String getTmp() {
        return String.valueOf(tmp);
    }

    public static Currency tmp= Currency.USD;
    // інформація валюти






    public static void settingsMenuButton(){

        boolean exit=true;

        while (exit==true){
            System.out.println("налаштування");
            System.out.println("1 - Банк\n"+
                    "2 - Валюта\n"+
                    "3 - знаків після коми\n"+
                    "4- вихід\n"+
                    ">");
            switch (scanner.nextLine()){
                case "1":
                    System.out.println();
                    System.out.println("Який банк вас цікавить?");
                    System.out.println("1 - НБУ\n" +
                            "2 - МоноБанк\n" +
                            "3 - ПриватБанк\n" +
                            "0 - Вихід\n" +
                            ">");

                    break;
                case "2":

                    System.out.println("Яка валюта вас цікавить?");
                    System.out.println("Вибір:USD/EUR\n" +
                            ">");

                    break;
                case "3":
                    System.out.println("1 - 2 коми\n" +
                            "2 - 3 коми\n" +
                            "3 - 4 коми\n" +
                            "0 - Вихід\n" +
                            ">");

                    break;





                case"4":exit=false;
            }
        }

    }
    public static String bankMenuButton(String tmp){
        String d="";


            switch (tmp){

                case "НБУ": bankChoice=Bank.НБУ;
                d="НБУ";
                    break;
                case "Монобанк":bankChoice=Bank.Монобанк;
                    d="Монобанк";
                    break;
                case "ПриватБанк":
                    bankChoice=Bank.ПриватБанк;
                    d="ПриватБанк";
                    break;

            }
        return d;
    }
    public static RateResponceDto Curracy(String temp){
        RateResponceDto f = null;
        switch (temp ) {
            case "USD":
                switch (bankChoice){
                    case НБУ:
                        f=apiNBY.getRates(parseChose).get(0);
                        tmp=Currency.USD;
                        break;

                    case Монобанк:
                        f= apiMONO.getRates(parseChose).get(0);
                        tmp=Currency.USD;
                        break;
                    case ПриватБанк:
                        f=  apiPRIVAT.getRates(parseChose).get(1);
                        tmp=Currency.USD;
                        break;
                }
                break;
            case "EUR":
                switch (bankChoice){
                    case НБУ: f=apiNBY.getRates(parseChose).get(1);
                        tmp=Currency.EUR;
                        break;
                    case Монобанк:
                        f= apiMONO.getRates(parseChose).get(1);
                        tmp=Currency.EUR;
                        break;
                    case ПриватБанк:
                        f=apiPRIVAT.getRates(parseChose).get(0);
                        tmp=Currency.EUR;
                        break;
                }
                break;
            default:
                System.out.println("На жаль валюти " + tmp +" немає!Спробуйте ще раз.");
        }
        return f;
    }
    public static void EUR_Button(){

    }
    public static void USD_Button(){

    }
    public static String parseMenuButton(String chose ){

String f="";

            switch (chose){
                case "2": parseChose=2;
                    f= String.valueOf(parseChose);


                    break;
                case "3":parseChose=3;
                    f= String.valueOf(parseChose);

                    break;
                case "4":parseChose=4;
                    f= String.valueOf(parseChose);

                    break;

            }

   return f; }

    public static String getA() {

        PrettyPrintCurrencyService prettyPrintCurrencyService=new PrettyPrintCurrencyService();
        RateResponceDto f=Curracy(String.valueOf(tmp));

        return prettyPrintCurrencyService.convert(String.valueOf(f.getRateBuy()),String.valueOf(f.getRateSell()),String.valueOf(bankChoice),String.valueOf(tmp)) ;
    }
}

