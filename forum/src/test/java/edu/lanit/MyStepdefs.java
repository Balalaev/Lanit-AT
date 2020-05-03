package edu.lanit;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideWait;
import cucumber.api.java.ru.И;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MyStepdefs {
    @И("открываем сайт")
    public void открываемСайт() {
        open("https://dev.n7lanit.ru/");
    }

    @И("находим кнопку Войти")
    public void находимКнопкуВойти() {
        $(By.xpath(
                "//div[@class='nav nav-guest']/button[@class='btn navbar-btn btn-default btn-sign-in']")).click();
    }

    @И("вводим логин")
    public void вводимЛогин() {
        $(By.xpath("//div[@class='control-input']/input[@id='id_username']")).val("balabaska");
    }

    @И("вводим пароль и авторизируемся")
    public void вводимПарольИАвторизируемся() {
        $(By.xpath("//div[@class='control-input']/input[@id='id_password']")).val("Lanit2020").pressEnter();
    }

    @И("проверяем авторизацию")
    public void проверяемАвторизацию() {
        $(By.xpath("//div[@id='user-menu-mount']//li[@class='dropdown']/a/img")).shouldBe(enabled);
    }

    @И("выбираем случайную тему")
    public void выбираемСлучайнуюТему() {
        ElementsCollection collection = $$(By.xpath(
                "//li[@class='list-group-item thread-new']//a[@class='item-title thread-title']"));
        collection.get((int) (collection.size()*Math.random())).click();
    }

    @И("находим и жмем кнопку Ответить")
    public void находимИЖмемКнопкуОтветить() {
        Selenide.sleep(1000);
        $(By.xpath(
                "//div[@class='col-sm-4 hidden-xs']/button[@class='btn btn-primary btn-block btn-outline']")).shouldHave(
                text("Ответить")).click();
    }

    @И("пишем комментарий")
    public void пишемКомментарий() {
        $(By.xpath("//div/textarea")).shouldBe(visible).val("Hello World!").submit();
    }

    @И("проверяем наличие комментария")
    public void проверяемНаличиеКомментария() {
        $(By.xpath("//div[@class='post-body']/article/p[contains(text(),'Hello World!')]")).isDisplayed();
    }

    @И("переходим во вкладку Темы")
    public void переходимВоВкладкуТемы() {
        $(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Темы')]")).shouldBe(visible).click();
    }

    @И("выбираем снова случайную тему")
    public void выбираемСноваСлучайнуюТему() {
        ElementsCollection collection = $$(By.xpath(
                "//li[@class='list-group-item thread-new']//a[@class='item-title thread-title']"));
        collection.get((int) (collection.size()*Math.random())).click();
    }

    @И("опять находим и жмем кнопку Ответить")
    public void опятьНаходимИЖмемКнопкуОтветить() {
        $(By.xpath(
                "//div[@class='col-sm-4 hidden-xs']/button[@class='btn btn-primary btn-block btn-outline']")).shouldHave(
                text("Ответить")).click();
    }

    @И("пишем еще один комментарий")
    public void пишемЕщеОдинКомментарий() {
        $(By.xpath("//div/textarea")).shouldBe(visible).val("Hello World!").submit();
    }

    @И("проверяем наличие нового комментария")
    public void проверяемНаличиеНовогоКомментария() {
        $(By.xpath("//div[@class='post-body']/article/p[contains(text(),'Hello World!')]")).isDisplayed();
    }

    @И("переходим обратно во вкладку Темы")
    public void переходимОбратноВоВкладкуТемы() {
        $(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Темы')]")).shouldBe(visible).click();
    }
}
