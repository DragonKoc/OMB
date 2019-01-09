package Speak;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joke {
    public List<String> joking = new ArrayList<>();
    public List<String> jokingA = new ArrayList<>();

    Joke() {

        joking.add("анекдот");
        joking.add("шутка");
        joking.add("шутку");
        joking.add("расскажи шутку");
        joking.add("скажи шутку");
        joking.add("расскажи анекдот");
        joking.add("скажи анекдот");

        jokingA.add("Опа-па-п... я ебу... алибабу))");
        jokingA.add("Ехай нахуй...ннаааавсееегдааааа-а-а-а-а");
        jokingA.add("Хуяку в сраку! чтобы голова не мантылялась!");


    }

    public String getRandomAnswear() {
        Random rand = new Random();
        String response = jokingA.get(rand.nextInt(jokingA.size()));
        return response;
    }
}
