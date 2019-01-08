package com.tgbot.omb;


import Speak.SpeakBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class OurBot extends TelegramLongPollingBot {


   // @Override
    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onUpdateReceived(Update update) {
        // проверка есть ли в обновлении сообщение и текст сообщения
        // очередь ожидающих запросов
//        if (update.hasMessage() && update.getMessage().hasText()) {
//            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
//                    .setChatId(update.getMessage().getChatId())
//                    .setText(update.getMessage().getText());
//            try {
//                execute(message); // Call method to send the message
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        }
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            String response = SpeakBot.processIncomingMessage(message);
            sendMsg(message, response);
        }}



    @Override
    public String getBotUsername() {
        // variable heroku Config Vars
        return System.getenv("username");
        
    }

    @Override
    public String getBotToken() {
        // variable heroku Config Vars
        return System.getenv("token");
        //return null; //add our key
    }

}

