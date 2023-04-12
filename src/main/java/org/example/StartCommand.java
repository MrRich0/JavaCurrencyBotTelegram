package org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.Collections;

public class StartCommand extends BotCommand {

    public StartCommand() {
        super("start", "Start command");
    }

    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String textHello = "Вітаємо вас! Цей бот допоможе відслідкувати актуальні курси валют";

        SendMessage message = new SendMessage();
        message.setText(textHello);
        message.setChatId(chat.getId());

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

        message.setReplyMarkup(keyboard);
        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}

