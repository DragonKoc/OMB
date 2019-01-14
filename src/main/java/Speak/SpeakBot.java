package Speak;

import com.tgbot.omb.OurBot;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.List;

public class SpeakBot {

    public static String processIncomingMessage(Message incomingMessage) {
        GreetingsRandomizer greetingsRandomizer = new GreetingsRandomizer();
        Joke joke = new Joke();

        Message message = incomingMessage;
        String responseMessage = null;

        if (message.getText().contains("/")) {

            switch (message.getText()) {
                case "/start":
                    responseMessage = "Привет, это мое первое сообщение";
                    break;
                case "/help":
                    responseMessage = "Чаво тебе?\n Пока я не знаю еше актуальных тем для рахговоров... но научусь)";
                    break;
                case "/setting":
                    responseMessage = "Приступим к настройкам...";
                    break;
                case "/weather":
                    responseMessage = "В окно выглянь и не заебуй";
                    break;
                case "/snow_lvl":
                    responseMessage = "Ты хоть сам понял что спросил?";
                    break;
                //fixme
            }

        } else if (message.getText().toLowerCase().contains("ghbdtn"))
            responseMessage = "смени расскладку... \uD83D\uDE0F";
            // greetings
        else if (greetingsRandomizer.greetings.contains(message.getText().toLowerCase())) {

            responseMessage = greetingsRandomizer.getRandomGreeting();

        }
        // how are you
        else if (message.getText().toLowerCase().startsWith("как дела")) {

            responseMessage = "Нармарна, а у тебя?";
        }


        //ping
        else if (message.getText().toLowerCase().startsWith("ping")) {

            responseMessage = "pong";

        } else if (message.getText().toLowerCase().startsWith("пинг")) {

            responseMessage = "понг";

        }

        //@
        else if (message.getText().toLowerCase().startsWith("@")) {

            responseMessage = "я в душу не ебу гифки... пока )";

        }

        //responce
        else if (message.getText().toLowerCase().contains("нормально")) {

            responseMessage = "\uD83D\uDE06";

        } else if (message.getText().toLowerCase().contains("плохо")) {

            responseMessage = "\uD83D\uDE22";

        } else if (message.getText().toLowerCase().contains("хорошо")) {

            responseMessage = "\uD83D\uDE0F";

        }


        //пивасик
        else if (message.getText().toLowerCase().contains("пиво")) {

            responseMessage =
                    "$............................$$$.........................$ \n" +
                            "$..$........................$$$.......................$........$ \n" +
                            "$...$$...................$$$$$..................$$.........$ \n" +
                            "$....$$$................$$$$$...............$$$..........$ \n" +
                            "$.....$$$$$...........$$$$$..........$$$$$...........$ \n" +
                            "$......$$$$$$$......$$$$$.....$$$$$$$............$ \n" +
                            "$........$$$$$$$....$$$$$...$$$$$$$..............$ \n" +
                            "$.............$$$$$......$$$.....$$$$$...................$ \n" +
                            "$..$$$$$$$.....$$$..$$$..$$$......$$$$$$$.......$ \n" +
                            "$......$$$$$$$$....$$.$.$$....$$$$$$$$...........$ \n" +
                            "$..........$$$$$$$$$.$$$.$$$$$$$$$...............$ \n" +
                            "$.........................$$$.$.$$$..............................$ \n" +
                            "$...................$$$$$...$...$$$$$..................$ \n" +
                            "$.....................$..........................$";
        }

        //...
        else if (message.getText().toLowerCase().contains("что ты умеешь")) {

            responseMessage = "/help";

        }

        //joke
        else if (joke.joking.contains(message.getText().toLowerCase())) {

            responseMessage = joke.getRandomAnswear();

        }

        // govorilka
        else {

            responseMessage = "Вы говорите " + message.getText();

        }

        return responseMessage; //fixme
    }


}
