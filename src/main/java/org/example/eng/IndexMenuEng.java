package org.example.eng;

import org.example.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class IndexMenuEng {
    public static void IndexMenu(String chatId) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Search by movie code"));
        row1.add(new KeyboardButton("Search by country"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Back \uD83D\uDD19"));

        keyboard.add(row1);
        keyboard.add(row2);

        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);

        sendReplyMessage(chatId, "Select the optional menu", keyboardMarkup);
    }

    public static void sendReplyMessage(String chatId, String text, ReplyKeyboardMarkup keyboardMarkup) {

        SendMessage message = new SendMessage();

        message.setChatId(chatId);
        message.setText(text);
        message.setReplyMarkup(keyboardMarkup);
        message.setParseMode("HTML");

        Bot bot = new Bot();

        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}