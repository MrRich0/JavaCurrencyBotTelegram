package org.example.command;

import org.example.bank.Bank;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Collections;

public class Buttons {

    public static InlineKeyboardMarkup getButtonsInfoAndSettings(){
        InlineKeyboardButton buttonInfo = InlineKeyboardButton
                .builder()
                .text("Отримати інформацію")
                .callbackData("Отримати інформацію")
                .build();
        InlineKeyboardButton buttonSettings = InlineKeyboardButton
                .builder()
                .text("Налаштування")
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
                .text("Банк")
                .callbackData("Банк")
                .build();
        InlineKeyboardButton buttonCurrency = InlineKeyboardButton
                .builder()
                .text("Валюта")
                .callbackData("Валюта")
                .build();
        InlineKeyboardButton buttonTime = InlineKeyboardButton
                .builder()
                .text("Час сповіщень")
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
 public   static InlineKeyboardMarkup getButtonsOfParse(){

     InlineKeyboardButton button2 = InlineKeyboardButton
             .builder()
             .text("2")
             .callbackData("2")
             .build();
     InlineKeyboardButton button3 = InlineKeyboardButton
             .builder()
             .text("3")
             .callbackData("3")
             .build();
     InlineKeyboardButton button4 = InlineKeyboardButton
             .builder()
             .text("4")
             .callbackData("4")
             .build();
     InlineKeyboardButton buttonBack = InlineKeyboardButton
             .builder()
             .text("назад")
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
    public static InlineKeyboardMarkup getButtonsBank(){
        InlineKeyboardButton button2 = InlineKeyboardButton
                .builder()
                .text("НБУ")
                .callbackData("НБУ")
                .build();
        InlineKeyboardButton button3 = InlineKeyboardButton
                .builder()
                .text("Монобанк")
                .callbackData("Монобанк")
                .build();
        InlineKeyboardButton button4 = InlineKeyboardButton
                .builder()
                .text("ПриватБанк")
                .callbackData("ПриватБанк")
                .build();
        InlineKeyboardMarkup keyboard = InlineKeyboardMarkup
                .builder()
                .keyboard(Collections.singleton(Collections.singletonList(button2)))
                .keyboard(Collections.singleton(Collections.singletonList(button3)))
                .keyboard(Collections.singleton(Collections.singletonList(button4)))

                .build();

        return keyboard;
    }
    public static InlineKeyboardMarkup getButtonsCurr(){
        InlineKeyboardButton button2 = InlineKeyboardButton
                .builder()
                .text("USD")
                .callbackData("USD")
                .build();
        InlineKeyboardButton button3 = InlineKeyboardButton
                .builder()
                .text("EUR")
                .callbackData("EUR")
                .build();

        InlineKeyboardMarkup keyboard = InlineKeyboardMarkup
                .builder()
                .keyboard(Collections.singleton(Collections.singletonList(button2)))
                .keyboard(Collections.singleton(Collections.singletonList(button3)))


                .build();

        return keyboard;
    }

}
