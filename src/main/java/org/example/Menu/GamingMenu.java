package org.example.Menu;

import org.example.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class GamingMenu {
    public static void gamingMenu(String chatId) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Pul ishlash \uD83D\uDCB0"));
        row1.add(new KeyboardButton("Markaet bo'limi \uD83C\uDFEA"));


        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Citiy market \uD83C\uDFEC"));
        row2.add(new KeyboardButton("Ayriboshlash ♻\uFE0F"));


        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("Sell market \uD83D\uDCE4"));
        row3.add(new KeyboardButton("Buy market \uD83D\uDCE5"));

        KeyboardRow row4 = new KeyboardRow();
        row4.add(new KeyboardButton("O'yin qoydalari \uD83D\uDCDA"));
        row4.add(new KeyboardButton("Reyting \uD83D\uDCCA"));

        KeyboardRow row5 = new KeyboardRow();
        row5.add(new KeyboardButton("Sozlamalar ⚙\uFE0F"));

        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);
        keyboard.add(row5);

        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);

        sendReplyMessage(chatId, "Tilni tanlang:", keyboardMarkup);
    }

    public static void sendReplyMessage(String chatId, String s, ReplyKeyboardMarkup keyboardMarkup) {

        SendMessage message = new SendMessage();

        message.setText(s);
        message.setChatId(chatId);
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
