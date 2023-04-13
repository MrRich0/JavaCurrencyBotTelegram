package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TelegramBotService {
    private TelegramCurrencyBot telegramCurrencyBot;

    public TelegramBotService(){
        telegramCurrencyBot = new TelegramCurrencyBot();
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(telegramCurrencyBot); // зареєстрували бота
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}