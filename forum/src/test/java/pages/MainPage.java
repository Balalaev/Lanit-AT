package pages;


import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;



public class MainPage {

    public WebElement loginButton() {
        return $(By.xpath(
                "//div[@class='nav nav-guest']/button[@class='btn navbar-btn btn-default btn-sign-in']"));
    }

    public WebElement loginField() {

        return $(By.xpath("//div[@class='control-input']/input[@id='id_username']"));
    }

    public WebElement passwordField() {

        return $(By.xpath("//div[@class='control-input']/input[@id='id_password']"));
    }

    public WebElement submit() {

        return $(By.xpath("//div/form/div/button[contains(text(),'Войти')]/."));
    }

    public WebElement avatar() {

        return $(By.xpath("//div[@id='user-menu-mount']//li[@class='dropdown']/a/img"));
    }


    public WebElement randomTopic() {
        ElementsCollection collection = $$(By.xpath(
                "//li[@class='list-group-item thread-new']//a[@class='item-title thread-title']"));
        WebElement topic = collection.get((int) (collection.size()*Math.random()));
        return topic;
    }
}

