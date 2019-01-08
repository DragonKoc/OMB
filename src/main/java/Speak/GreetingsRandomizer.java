package Speak;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GreetingsRandomizer {
    public List<String> greetings = new ArrayList<>();

    GreetingsRandomizer() {
        greetings.add("Zdarova");
        greetings.add("Zdorovin'ki buly!");
        greetings.add("Hi!");
        greetings.add("Hi");
        greetings.add("hi");
        greetings.add("privet");
        greetings.add("привет");
        greetings.add("Привет");
        greetings.add("ПРИВЕТ");
        greetings.add("привет!");
        greetings.add("Привет!");
        greetings.add("ПРИВЕТ!");

    }

    public String getRandomGreeting() {
        Random rand = new Random();
        String response = greetings.get(rand.nextInt(greetings.size()));
        if (response.toLowerCase().contains("п"))
            return response + ", я телеграм бот, который живет на классном ноутбуке Кости.";
        else
            return response + ", ya telegram-bot kotoriy zhivet na klassnom krasivom noutbuke Kosti.";
    }
}
