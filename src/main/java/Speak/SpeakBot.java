package Speak;

import com.tgbot.omb.OurBot;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.List;

public class SpeakBot {

    public static String processIncomingMessage(Message incomingMessage) {
        GreetingsRandomizer greetingsRandomizer = new GreetingsRandomizer();

        Message message = incomingMessage;
        String responseMessage = null;


        if (message.getText().contains("/")) {

            switch (message.getText()) {
                case "/start":
                    responseMessage = "Привет, это мое первое сообщение";
                    break;
                case "/help":
                    responseMessage = "Чаво тебе?";
                    break;
                case "/setting":
                    responseMessage = "Приступим к настройкам...";
                    break;
                //fixme
            }

        } else if (greetingsRandomizer.greetings.contains(message.getText())) {

            responseMessage = greetingsRandomizer.getRandomGreeting();
        } else {

            responseMessage = "Дядя говорит " + message.getText();

        }

        return responseMessage; //fixme
    }


}
