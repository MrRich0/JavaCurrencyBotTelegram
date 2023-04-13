package org.example;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.example.command.StartCommand;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramCurrencyBot extends TelegramLongPollingCommandBot {

    public TelegramCurrencyBot(){
        register(new StartCommand());
    }

    @Override
    public String getBotToken(){
        return BotConstants.BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BotConstants.BOT_NAME;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        System.out.println("Non-command here");
    }
}
