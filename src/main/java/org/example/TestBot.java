package org.example;

import org.example.ParseMono.MONOCurrencyRateService;
import org.example.ParseNBY.NBYCurrencyRateService;
import org.example.ParsePrivat.PrivatCurrencyRateService;

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
    public static void main(String[] args) throws IOException {


        boolean mainMenuExit=true;

        while (mainMenuExit==true){
            RateResponceDto a=Curracy(tmp);
            System.out.println("головне меню");
            System.out.println("1 - вивід іформації\n"+
                    "2 - Налаштування\n"+
                    "3 - вихід\n"+
                    ">");
            switch (scanner.nextLine()){
                case "1":
                    System.out.println(a);
                    break;
                case "2":
                    settingsMenuButton();
                    break;
                case "3":mainMenuExit=false;
                    break;
            }}

    }



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
            bankMenuButton();
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
parseMenuButton();
break;





            case"4":exit=false;
        }
        }

    }
    public static void bankMenuButton(){
boolean bankExit =true;
while (bankExit==true){
            switch (scanner.nextLine()){

                case "1": bankChoice=1;
                    break;
                case "2":bankChoice=2;
                    break;
                case "3":
                    bankChoice=3;
                    break;
                case "0":bankExit=false;
                break;
            }
    }
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
    public static void parseMenuButton(){
        boolean parseExit=true;

        while (parseExit==true){
            switch (scanner.nextLine()){
                case "1": parseChose=2;
                break;
                case "2":parseChose=3;
                break;
                case "3":parseChose=4;
                break;
                case "0":parseExit=false;
            }
        }
    }

}
