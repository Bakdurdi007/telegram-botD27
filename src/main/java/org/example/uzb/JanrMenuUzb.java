package org.example.uzb;

import org.example.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class JanrMenuUzb {
    public static void janrMenu(String chatId){
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Xayotiy"));
        row1.add(new KeyboardButton("Badiy"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Meladramma"));
        row2.add(new KeyboardButton("Kamediya"));

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("Fantastik"));
        row3.add(new KeyboardButton("Dramma"));

        KeyboardRow row = new KeyboardRow();
        row.add(new KeyboardButton("Orqaga \uD83D\uDD19\uD83D\uDD19\uD83D\uDD19"));

        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row);

        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);

        sendReplyMessage(chatId, "Ixtiyoriy menyuni tanlang", keyboardMarkup);

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
