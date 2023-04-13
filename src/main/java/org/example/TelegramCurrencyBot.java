package org.example;

import org.example.command.Settings;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.example.command.StartCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.Collections;

public class TelegramCurrencyBot extends TelegramLongPollingCommandBot {

    public TelegramCurrencyBot(){
        register(new StartCommand());
        register(new Settings());
    }

    @Override
    public String getBotToken(){
        return null;
    }

    @Override
    public String getBotUsername() {
        return BotConstants.BOT_NAME;
    }

    @Override
    public void processNonCommandUpdate(Update update) {

        if(update.hasCallbackQuery()) {
            String data = update.getCallbackQuery().getData();
            if (data.equals("Отримати інформацію")) {
                SendMessage messageInfo = new SendMessage();
                messageInfo.setText("Currency rate");
                Long chatId = update.getCallbackQuery().getMessage().getChatId();
                messageInfo.setChatId(chatId);
                try {
                    execute(messageInfo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } if (data.equals("Налаштування")) {
                    SendMessage message = new SendMessage();
                    message.setText("Налаштування");
                    Long chatId = update.getCallbackQuery().getMessage().getChatId();
                    message.setChatId(chatId);

                    InlineKeyboardButton buttonNumberOfDecimalPlaces = InlineKeyboardButton
                            .builder()
                            .text("Обрати кількість знаків після коми")
                            .callbackData("Обрати кількість знаків після коми")
                            .build();
                    InlineKeyboardButton buttonBank = InlineKeyboardButton
                            .builder()
                            .text("Обрати банк")
                            .callbackData("Обрати банк")
                            .build();
                    InlineKeyboardButton buttonCurrency = InlineKeyboardButton
                            .builder()
                            .text("Обрати валюту")
                            .callbackData("Обрати валюту")
                            .build();
                    InlineKeyboardButton buttonTime = InlineKeyboardButton
                            .builder()
                            .text("Обрати час сповіщень")
                            .callbackData("Обрати час сповіщень")
                            .build();
                    InlineKeyboardMarkup keyboard = InlineKeyboardMarkup
                            .builder()
                            .keyboard(Collections.singleton(Collections.singletonList(buttonNumberOfDecimalPlaces)))
                            .keyboard(Collections.singleton(Collections.singletonList(buttonBank)))
                            .keyboard(Collections.singleton(Collections.singletonList(buttonCurrency)))
                            .keyboard(Collections.singleton(Collections.singletonList(buttonTime)))
                            .build();
                    message.setReplyMarkup(keyboard);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
