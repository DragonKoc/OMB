package com.tgbot.omb;


import Buttons.Button;
import Speak.SpeakBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class OurBot extends TelegramLongPollingBot {

    //initialized button
    Button button = new Button();

   // @Override
    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {

            button.setButton(sendMessage);
            execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            String response = SpeakBot.processIncomingMessage(message);
            sendMsg(message, response);
        }}



    @Override
    public String getBotUsername() {
        // variable heroku Config Vars
        //return System.getenv("username");
        // return null; //add our name
        return "opravday_macbook_bot";
    }


    @Override
    public String getBotToken() {
        // variable heroku Config Vars
        //return System.getenv("token");
        // return null; //add our key
        //return "709217752:AAEvjRxFKJjejPE0q-3lOG_1k1_AR4rpaWo";
    }

}

