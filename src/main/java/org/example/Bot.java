package org.example;

import org.example.Menu.LanguageMenu;
import org.example.eng.IndexMenuEng;
import org.example.rus.IndexMenuRus;
import org.example.uzb.CountryMenuUzb;
import org.example.uzb.IndexMenuUzb;
import org.example.uzb.JanrMenuUzb;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "- - - - - - -";
    }

    @Override
    public String getBotToken() {
        return "- - - - - - - - - - -";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();

            if (text.equals("/start") || text.equals("Orqaga \uD83D\uDD19") || text.equals("Назад \uD83D\uDD19") || text.equals("Back \uD83D\uDD19")) {
                LanguageMenu.sendLanguageSelectionMenu(chatId);
            }else if(text.equals("Uzb \uD83C\uDDFA\uD83C\uDDFF") || text.equals("Orqaga \uD83D\uDD19\uD83D\uDD19")){
                IndexMenuUzb.IndexMenu(chatId);
            }else if(text.equals("Eng \uD83C\uDDFA\uD83C\uDDF8")){
                IndexMenuEng.IndexMenu(chatId);
            }else if(text.equals("Rus \uD83C\uDDF7\uD83C\uDDFA")){
                IndexMenuRus.IndexMenu(chatId);
            }else if(text.equals("Kino kodi bo'yicha izlash")){
                Message1(chatId, "<i><b>Assalom alaykum kinolar olami telegram botiga xush kelibsiz! Kino kodini kiriting!</b></i> ");
            }else if(text.equals("Search by movie code")){
                Message1(chatId, "<i><b>Hello, welcome to the world of movies telegram bot! Enter the movie code!</b></i> ");
            }else if(text.equals("Поиск по коду фильма")){
                Message1(chatId, "<i><b>Привет, добро пожаловать в мир кинотелеграмм-бота! Введите код фильма!</b></i> ");
            } else if (text.equals("Davlat bo'yicha izlash") || text.equals("Orqaga \uD83D\uDD19\uD83D\uDD19\uD83D\uDD19")) {
                CountryMenuUzb.countryMenu(chatId);
            } else if (text.equals("O'zbekiston")) {
                JanrMenuUzb.janrMenu(chatId);
            } else if (text.equals("Amerika")) {
                JanrMenuUzb.janrMenu(chatId);
            } else if (text.equals("Hindiston")) {
                JanrMenuUzb.janrMenu(chatId);
            } else if (text.equals("Janubiy Koreya")) {
                JanrMenuUzb.janrMenu(chatId);
            }
        }
    }

    public void Message1(String chatId, String text) {

        SendMessage message = new SendMessage();

        message.setChatId(chatId);
        message.setText(text);
        message.setParseMode("HTML");

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    public void SendMovie(String chatId, String url, String title) {

        SendPhoto sendPhoto = new SendPhoto();

        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile(new File(url)));
        sendPhoto.setCaption(title);
        sendPhoto.setParseMode("HTML");

        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
