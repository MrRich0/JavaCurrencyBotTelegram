package org.example.command;

import org.example.BotLogic;
import org.example.Currency;
import org.example.bank.Bank;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.*;

import static org.example.BotLogic.chosenCurrency;
import static org.example.bank.Bank.*;
import static org.example.command.BankSetting.getSavedBank;

public class Buttons {
public static BotLogic botLogic=new BotLogic();

    public static InlineKeyboardMarkup getButtonsInfoAndSettings(){
        InlineKeyboardButton buttonInfo = InlineKeyboardButton
                .builder()
                .text("✉️"+"Отримати інформацію")
                .callbackData("Отримати інформацію")
                .build();
        InlineKeyboardButton buttonSettings = InlineKeyboardButton
                .builder()
                .text("⚙️" + "Налаштування")
                .callbackData("Налаштування")
                .build();
        InlineKeyboardMarkup keyboard = InlineKeyboardMarkup
                .builder()
                .keyboard(Collections.singleton(Collections.singletonList(buttonInfo)))
                .keyboard(Collections.singleton(Collections.singletonList(buttonSettings)))
                .build();

        return keyboard;
    }
    public static InlineKeyboardMarkup getButtonsOfSettings(){
        InlineKeyboardButton buttonNum = InlineKeyboardButton
                .builder()
                .text("Кількість знаків після коми")
                .callbackData("Кількість знаків після коми")
                .build();
        InlineKeyboardButton buttonBank = InlineKeyboardButton
                .builder()
                .text("\uD83C\uDFE6" + "Банк")
                .callbackData("Банк")
                .build();
        InlineKeyboardButton buttonCurrency = InlineKeyboardButton
                .builder()
                .text("💵" + "Валюта")
                .callbackData("Валюта")
                .build();
        InlineKeyboardButton buttonTime = InlineKeyboardButton
                .builder()
                .text("🕐" + "Час сповіщень")
                .callbackData("Час сповіщень")
                .build();
        InlineKeyboardMarkup keyboard = InlineKeyboardMarkup
                .builder()
                .keyboard(Collections.singleton(Collections.singletonList(buttonNum)))
                .keyboard(Collections.singleton(Collections.singletonList(buttonBank)))
                .keyboard(Collections.singleton(Collections.singletonList(buttonCurrency)))
                .keyboard(Collections.singleton(Collections.singletonList(buttonTime)))
                .build();

        return keyboard;

    }
     public static class NumberSymbolsAfterCommaSetting {
    static BotLogic botLogic=new BotLogic();

    static String setButton2Name() {
        return  (String.valueOf(botLogic.parseChose).equals("2")) ? "2" + " ✅" : "2" ;
    }

  static   String setButton3Name() {
        return  (String.valueOf(botLogic.parseChose).equals("3")) ? "3" + " ✅" : "3" ;
    }

  static   String setButton4Name() {
        return  (String.valueOf(botLogic.parseChose).equals("4")) ? "4" + " ✅" : "4" ;
    }
 public  static   InlineKeyboardMarkup getButtonsOfParse(Long chatId){


     InlineKeyboardButton button2 = InlineKeyboardButton
             .builder()
             .text(setButton2Name())
             .callbackData("2")
             .build();
     InlineKeyboardButton button3 = InlineKeyboardButton
             .builder()
             .text(setButton3Name())
             .callbackData("3")
             .build();
     InlineKeyboardButton button4 = InlineKeyboardButton
             .builder()
             .text(setButton4Name())
             .callbackData("4")
             .build();
     InlineKeyboardButton buttonBack = InlineKeyboardButton
             .builder()
             .text("🔙" + "Назад")
             .callbackData("назад")
             .build();
     InlineKeyboardMarkup keyboard = InlineKeyboardMarkup
             .builder()
             .keyboard(Collections.singleton(Collections.singletonList(button2)))
             .keyboard(Collections.singleton(Collections.singletonList(button3)))
             .keyboard(Collections.singleton(Collections.singletonList(button4)))
             .keyboard(Collections.singleton(Collections.singletonList(buttonBack)))
             .build();

     return keyboard;
 }
     }
    public static class Num{
        static BotLogic botLogic=new BotLogic();

        static String setButton2Name() {
            return  (String.valueOf(BotLogic.bankChoice).equals("НБУ")) ? "НБУ" + " ✅" : "НБУ" ;
        }

        static   String setButton3Name() {
            return  (String.valueOf(BotLogic.bankChoice).equals("Монобанк")) ? "МоноБанк" + " ✅" : "МоноБанк" ;
        }

        static   String setButton4Name() {
            return  (String.valueOf(BotLogic.bankChoice).equals("ПриватБанк")) ? "ПриватБанк" + " ✅" : "ПриватБанк" ;
        }
    public static InlineKeyboardMarkup getButtonsBank(Long chatId){
        InlineKeyboardButton button2 = InlineKeyboardButton
                .builder()
                .text(setButton2Name())
                .callbackData("НБУ")
                .build();
        InlineKeyboardButton button3 = InlineKeyboardButton
                .builder()
                .text(setButton3Name())
                .callbackData("МоноБанк")
                .build();
        InlineKeyboardButton button4 = InlineKeyboardButton
                .builder()
                .text(setButton4Name())
                .callbackData("ПриватБанк")
                .build();
        InlineKeyboardButton buttonBack = InlineKeyboardButton
                .builder()
                .text("🔙" + "Назад")
                .callbackData("назад")
                .build();
        InlineKeyboardMarkup keyboard = InlineKeyboardMarkup
                .builder()
                .keyboard(Collections.singleton(Collections.singletonList(button2)))
                .keyboard(Collections.singleton(Collections.singletonList(button3)))
                .keyboard(Collections.singleton(Collections.singletonList(button4)))
                .keyboard(Collections.singleton(Collections.singletonList(buttonBack)))
                .build();

        return keyboard;
    }}
    public static InlineKeyboardMarkup getButtonsCurr(Long chatId){
        InlineKeyboardButton button2 = InlineKeyboardButton
                .builder()
                .text((chosenCurrency.contains(Currency.USD)) ? "USD" + " ✅" : "USD")
                .callbackData("USD")
                .build();
        InlineKeyboardButton button3 = InlineKeyboardButton
                .builder()
                .text((chosenCurrency.contains(Currency.EUR)) ? "EUR" + " ✅" : "EUR")
                .callbackData("EUR")
                .build();

        InlineKeyboardButton buttonBack = InlineKeyboardButton
                .builder()
                .text("🔙" + "Назад")
                .callbackData("назад")
                .build();

        InlineKeyboardMarkup keyboard = InlineKeyboardMarkup
                .builder()
                .keyboard(Collections.singleton(Collections.singletonList(button2)))
                .keyboard(Collections.singleton(Collections.singletonList(button3)))
                .keyboard(Collections.singleton(Collections.singletonList(buttonBack)))
                .build();

        return keyboard;
    }}


//    public static List<Currency> getSavedCurrencies(long chatId){
//        if (savedCurrencies.containsKey(chatId)) {
//            return savedCurrencies.get(chatId);
//        } else {
//            List<Currency> savedList = new ArrayList<>();
//            savedList.add(chosenCurrency);
//            return savedList;
//        }
//    }
//
//}
