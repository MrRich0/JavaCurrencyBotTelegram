package org.example.command;

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
}
