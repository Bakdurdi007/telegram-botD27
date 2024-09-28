package org.example.Menu;

import org.example.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SendRasm {
    public static void sendLanguageSelectionMenu(String chatId){
        SendPhoto message = new SendPhoto();

        message.setChatId(String.valueOf(chatId));
        message.setCaption("<b><i> Ixtiyoriy menyudan bitta tilni tanlang!</i></b>");

        // Inline tugmalar
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(createInlineKeyboard());

        message.setPhoto(new InputFile(new File("img/3.jpg")));
        message.setReplyMarkup(inlineKeyboardMarkup);
        message.setParseMode("HTML");

        Bot bot = new Bot();

        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public static List<List<InlineKeyboardButton>> createInlineKeyboard() {

        // Tugmalarni yaratish
        InlineKeyboardButton minusButton = new InlineKeyboardButton();
        minusButton.setText("Uzb \uD83C\uDDFA\uD83C\uDDFF");
        minusButton.setCallbackData("uzb");

        InlineKeyboardButton zeroButton = new InlineKeyboardButton();
        zeroButton.setText("Rus \uD83C\uDDF7\uD83C\uDDFA");
        zeroButton.setCallbackData("rus");

        InlineKeyboardButton plusButton = new InlineKeyboardButton();
        plusButton.setText("Eng \uD83C\uDDFA\uD83C\uDDF8");
        plusButton.setCallbackData("eng");

        // Tugmalarni gorizantal ko'rinishda joylashtirish
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(minusButton);
        row.add(zeroButton);
        row.add(plusButton);

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        rows.add(row);

        return rows;
    }


}
