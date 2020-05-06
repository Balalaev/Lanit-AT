package edu.lanit;


import com.codeborne.selenide.Selenide;
import cucumber.api.java.ru.И;
import pages.MainPage;
import pages.TopicPage;

import static com.codeborne.selenide.Selenide.*;


public class MyStepdefs {
    MainPage main = new MainPage();
    TopicPage topicPage = new TopicPage();

    @И("открываем сайт")
    public void открываемСайт() {
        open("https://dev.n7lanit.ru");
    }

    @И("нажимаем кнопку Войти")
    public void нажимаемКнопкуВойти() {
        main.loginButton().click();
    }

    @И("находим поле Имя Пользователя и вводим логин")
    public void НаходимПолеИмяПользователяИВводимЛогин() {
        main.loginField().sendKeys("balabaska");
    }

    @И("находим поле Пароль и вводим пароль")
    public void НаходимПолеПарольИВводимПароль() {
        main.passwordField().sendKeys("Lanit2020");
    }

    @И("нажимаем кнопку Войти2")
    public void наСтраницеНажимаемКнопкуВойти2() {
        main.submit().click();
    }

    @И("проверяем авторизацию")
    public void проверяемАвторизацию() {
        main.avatar().isDisplayed();
    }

    @И("выбираем случайную тему")
    public void выбираемСлучайнуюТему() {
        main.randomTopic().click();
    }

    @И("нажимаем кнопку Ответить")
    public void нажимаемКнопкуОтветить() {
        topicPage.requestButton().click();
    }

    @И("находим текстовое поле и вводим текст")
    public void находимТекстовоеПолеИВводимТекст() {
        topicPage.textArea().sendKeys("Luke, I Am Your Father");
    }

    @И("нажимаем кнопку Отправить ответ")
    public void нажимаемКнопкуОтправитьОтвет() {
        topicPage.sendRequestButton().click();
    }

    @И("проверяем что ответ опубликован")
    public void проверяемЧтоОтветОпубликован() {
        topicPage.requestCheck().isDisplayed();
    }

    @И("переходим на вкладку Темы")
    public void переходимНаВкладкуТемы() {
        topicPage.themes().click();
    }

    @И("повторяем шаги")
    public void повторяемШаги() {
        выбираемСлучайнуюТему();
        нажимаемКнопкуОтветить();
        находимТекстовоеПолеИВводимТекст();
        нажимаемКнопкуОтправитьОтвет();
        проверяемЧтоОтветОпубликован();
        переходимНаВкладкуТемы();
    }
}
