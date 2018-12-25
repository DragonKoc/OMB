package com.tgbot.omb;

//OpravdayMacbookBot - OMB

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
public class OmbApplication extends OurBot {

	//what next

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(OmbApplication.class, args);



		TelegramBotsApi botsApi = new TelegramBotsApi();

		try {
			botsApi.registerBot(new OurBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}


}

