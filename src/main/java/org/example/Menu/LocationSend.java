package org.example.Menu;

import org.example.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class LocationSend {

    public static void locationSend(String chatId) {
        sendLocation(chatId, 41.324066058564995, 69.24202887134464);
    }

    public static void sendLocation(String chatId, double latitude, double longitude) {
        SendLocation location = new SendLocation();

        location.setChatId(chatId);
        location.setLatitude(Double.valueOf((double) latitude));
        location.setLongitude(Double.valueOf((double) longitude));

        Bot bot = new Bot();

        try {
            bot.execute(location); // Send the location
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
