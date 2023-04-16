package org.example;

import org.example.command.Buttons;
import org.example.command.NotificationSetting;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.example.command.Buttons.NumberSimbolsAfterCommaSetting.getButtonsOfParse;


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
            sendMessage.setReplyMarkup(getButtonsOfParse(chatId1));
            execute(sendMessage);

        }
        if (Character.isDigit(callbackQueryData.charAt(0))){

            SendMessage sendMessage=new SendMessage();
            sendMessage.setText("ви обрали "+ botLogic.parseMenuButton(callbackQueryData));
            sendMessage.setChatId(chatId1);
            sendMessage.setReplyMarkup(Buttons.NumberSimbolsAfterCommaSetting.getButtonsOfParse(chatId1));
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
        if (callbackQueryData.equals("Час сповіщень")){
            SendMessage sendMessage =new SendMessage();
            sendMessage.setText("Виберіть час сповіщення");
            sendMessage.setChatId(chatId1);
            sendMessage.setReplyMarkup(NotificationSetting.getNotificationButtons(chatId1));

            execute(sendMessage);
        }

    }
    private void handleMessage(Message message) throws TelegramApiException {
        String text = message.getText();
        switch (text) {
            case "Повернутися":
                execute(SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("Оберіть бажану функцію.")
                        .replyMarkup(Buttons.getButtonsOfSettings())
                        .build());
                break;
            case "9":
                execute(SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("Надішлемо Вам сповіщення о 9 годині.")
                        .build());
                NotificationSetting.setNotification(message.getChatId(), NotificationSetting.Notification.NINE);
                break;
            case "10":
                execute(SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("Надішлемо Вам сповіщення о 10 годині.")
                        .build());
                NotificationSetting.setNotification(message.getChatId(), NotificationSetting.Notification.TEN);
                break;
            case "11":
                execute(SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("Надішлемо Вам сповіщення о 11 годині.")
                        .build());
                NotificationSetting.setNotification(message.getChatId(), NotificationSetting.Notification.ELEVEN);
                break;
            case "12":
                execute(SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("Надішлемо Вам сповіщення о 12 годині.")
                        .build());
                NotificationSetting.setNotification(message.getChatId(), NotificationSetting.Notification.TWELVE);
                break;
            case "13":
                execute(SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("Надішлемо Вам сповіщення о 13 годині.")
                        .build());
                NotificationSetting.setNotification(message.getChatId(), NotificationSetting.Notification.THIRTEEN);
                break;
            case "14":
                execute(SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("Надішлемо Вам сповіщення о 14 годині.")
                        .build());
                NotificationSetting.setNotification(message.getChatId(), NotificationSetting.Notification.FOURTEEN);
                break;
            case "15":
                execute(SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("Надішлемо Вам сповіщення о 15 годині.")
                        .build());
                NotificationSetting.setNotification(message.getChatId(), NotificationSetting.Notification.FIFTEEN);
                break;
            case "16":
                execute(SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("Надішлемо Вам сповіщення о 16 годині.")
                        .build());
                NotificationSetting.setNotification(message.getChatId(), NotificationSetting.Notification.SIXTEEN);
                break;
            case "17":
                execute(SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("Надішлемо Вам сповіщення о 17 годині.")
                        .build());
                NotificationSetting.setNotification(message.getChatId(), NotificationSetting.Notification.SEVENTEEN);
                break;
            case "18":
                execute(SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("Надішлемо Вам сповіщення о 18 годині.")
                        .build());
                NotificationSetting.setNotification(message.getChatId(), NotificationSetting.Notification.EIGHTEEN);
                break;
            case "Вимкнути сповіщення":
                execute(SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("Ви вимкнули сповіщення.")
                        .build());
                NotificationSetting.setNotification(message.getChatId(), NotificationSetting.Notification.OFF_NOTIFY);
                break;
        }
    }

    public void sendNotification(long chatId) throws TelegramApiException {

        execute(SendMessage.builder()
                .chatId(String.valueOf(chatId))
                .text(BotLogic.getFinalMessage())
                .replyMarkup(Buttons.getButtonsInfoAndSettings())
                .build());
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

        }else if (update.hasMessage() && update.getMessage().hasText()) {
            try {
                handleMessage(update.getMessage());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
}}