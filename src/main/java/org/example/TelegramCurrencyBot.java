package org.example;

import org.example.command.Buttons;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramCurrencyBot extends TelegramLongPollingBot {
    BotLogic botLogic =new BotLogic();
    public TelegramCurrencyBot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public String getBotToken() {
        return BotConstants.BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BotConstants.BOT_NAME;
    }

    public void commandStart(Update update) throws TelegramApiException {
        Long chatId1 = update.getMessage().getChatId();
        String text = update.getMessage().getText();
        if (text.equals("/start")) {

            SendMessage sendMessage = new SendMessage();
            sendMessage.setText("Вітаємо вас! Цей бот допоможе відслідкувати актуальні курси валют");
            sendMessage.setChatId(chatId1);
            sendMessage.setReplyMarkup(Buttons.getButtonsInfoAndSettings());
            execute(sendMessage);
        }
    }

    public void commandSettings(CallbackQuery callbackQuery) throws TelegramApiException {
        Long chatId1 = callbackQuery.getMessage().getChatId();
        String callbackQueryData = callbackQuery.getData();
        if (callbackQueryData.equals("Налаштування")) {

            SendMessage sendMessage = new SendMessage();
            sendMessage.setText("Налаштування");
            sendMessage.setChatId(chatId1);
            sendMessage.setReplyMarkup(Buttons.getButtonsOfSettings());
            execute(sendMessage);
        }
        if (callbackQueryData.equals("Отримати інформацію")) {

            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(botLogic.getFinalMessage());
            sendMessage.setChatId(chatId1);
            sendMessage.setReplyMarkup(Buttons.getButtonsInfoAndSettings());
            execute(sendMessage);


        }if (callbackQueryData.equals("Кількість знаків після коми")){

            SendMessage sendMessage = new SendMessage();
            sendMessage.setText("Кількість знаків після коми");
            sendMessage.setChatId(chatId1);
            sendMessage.setReplyMarkup(Buttons.getButtonsOfParse());
            execute(sendMessage);

        }
        if (Character.isDigit(callbackQueryData.charAt(0))){

            SendMessage sendMessage=new SendMessage();
            sendMessage.setText("ви обрали "+ botLogic.parseMenuButton(callbackQueryData));
            sendMessage.setChatId(chatId1);
            sendMessage.setReplyMarkup(Buttons.getButtonsInfoAndSettings());
            execute(sendMessage);
        }
        if (callbackQueryData.equals("Банк")) {

            SendMessage sendMessage = new SendMessage();
            sendMessage.setText("Банк");
            sendMessage.setChatId(chatId1);
            sendMessage.setReplyMarkup(Buttons.getButtonsBank());
            execute(sendMessage);
        }
    switch (callbackQueryData){
        case "ПриватБанк":
           case "Монобанк":
           case "НБУ":
               SendMessage sendMessage = new SendMessage();
               sendMessage.setText("ви вибрали "+ botLogic.bankMenuButton(callbackQueryData));
               sendMessage.setChatId(chatId1);
               sendMessage.setReplyMarkup(Buttons.getButtonsInfoAndSettings());
               execute(sendMessage);
    }
        if(callbackQueryData.equals("Валюта")){
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText("Валюта");
            sendMessage.setChatId(chatId1);
            sendMessage.setReplyMarkup(Buttons.getButtonsCurr());
            execute(sendMessage);

        }
        switch (callbackQueryData){
            case "USD":
            case "EUR":
                botLogic.Curracy(callbackQueryData);

                SendMessage sendMessage=new SendMessage();
                sendMessage.setText("ви вибрали"+ botLogic.getChosenCurrency());
sendMessage.setChatId(chatId1);
sendMessage.setReplyMarkup(Buttons.getButtonsInfoAndSettings());
execute(sendMessage);
        }
        if (callbackQueryData.equals("назад")){
            SendMessage sendMessage =new SendMessage();
            sendMessage.setText("Налаштування");
            sendMessage.setChatId(chatId1);
            sendMessage.setReplyMarkup(Buttons.getButtonsOfSettings());

            execute(sendMessage);
        }
    }



    @Override
    public void onUpdateReceived(Update update) {


        if (update.hasMessage() && update.getMessage().isCommand()) {
            try {
                commandStart(update);



            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

      } else if (update.hasCallbackQuery()) {
       try {
              commandSettings(update.getCallbackQuery());
           } catch (TelegramApiException e) {
               throw new RuntimeException(e);
          }

        }
}}