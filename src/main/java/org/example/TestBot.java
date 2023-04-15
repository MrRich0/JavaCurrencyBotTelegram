package org.example;

import org.example.ParseMono.MONOCurrencyRateService;
import org.example.ParseNBY.NBYCurrencyRateService;
import org.example.ParsePrivat.PrivatCurrencyRateService;
import org.example.command.Buttons;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.io.IOException;
import java.util.Scanner;


public class TestBot {
    static   CurrencyRateApiService apiNBY = new NBYCurrencyRateService();
    static   CurrencyRateApiService apiMONO = new MONOCurrencyRateService();
    static   CurrencyRateApiService apiPRIVAT = new PrivatCurrencyRateService();
    static Message notification = new Message();

    static Scanner scanner = new Scanner(System.in);
    public static int bankChoice=1;
    public static int parseChose=2;

    public static String tmp="USD";
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
                    tmp=scanner.nextLine().toUpperCase();
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

                case "НБУ": bankChoice=1;
                d="НБУ";
                    break;
                case "Монобанк":bankChoice=2;
                    d="Монобанк";
                    break;
                case "ПриватБанк":
                    bankChoice=3;
                    d="ПриватБанк";
                    break;

            }
        return d;
    }
    public static RateResponceDto Curracy(String tmp){
        RateResponceDto f = null;
        switch (tmp ) {
            case "USD":
                switch (bankChoice){
                    case 1:
                        f=apiNBY.getRates(parseChose).get(0);
                        break;

                    case 2:
                        f= apiMONO.getRates(parseChose).get(0);
                        break;
                    case 3:
                        f=  apiPRIVAT.getRates(parseChose).get(1);
                        break;
                }
                break;
            case "EUR":
                switch (bankChoice){
                    case 1: f=apiNBY.getRates(parseChose).get(1);
                        break;
                    case 2:
                        f= apiMONO.getRates(parseChose).get(1);
                        break;
                    case 3:
                        f=apiPRIVAT.getRates(parseChose).get(1);
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
        return String.valueOf(Curracy(tmp));
    }
}

