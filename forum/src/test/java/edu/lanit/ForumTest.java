package edu.lanit;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.*;

public class ForumTest {

    @BeforeTest
        public void before(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
        timeout = 6000;
    }

    @Test
    public void loginTest(){
        open("https://dev.n7lanit.ru/");
        $(By.xpath(
                "//div[@class='nav nav-guest']/button[@class='btn navbar-btn btn-default btn-sign-in']")).click();
        $(By.xpath("//div[@class='control-input']/input[@id='id_username']")).val("balabaska");
        $(By.xpath("//div[@class='control-input']/input[@id='id_password']")).val("Lanit2020").pressEnter();
        $(By.xpath("//div[@id='user-menu-mount']//li[@class='dropdown']/a/img")).shouldBe(enabled);
    }


    @Test
    public void randomThemesChooseAndAnswer(){
        ElementsCollection collection = $$(By.xpath(
                "//li[@class='list-group-item thread-read']//a[@class='item-title thread-title']"));
        collection.get((int) (collection.size()*Math.random())).click();
        $(By.xpath(
                "//div[@class='col-sm-4 hidden-xs']/button[@class='btn btn-primary btn-block btn-outline']")).shouldHave(
                        text("Ответить")).click();
        $(By.xpath("//div/textarea")).shouldBe(visible).val("Hello World!").submit();
        $(By.xpath("//div[@class='post-body']/article/p[contains(text(),'Hello World!')]")).isDisplayed();
        $(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Темы')]")).shouldBe(visible).click();
    }

    @Test
    public void repeatRandomThemesChooseAndAnswer(){
        ElementsCollection collection = $$(By.xpath(
                "//li[@class='list-group-item thread-read']//a[@class='item-title thread-title']"));
        collection.get((int) (collection.size()*Math.random())).shouldBe(visible).click();
        $(By.xpath(
                "//div[@class='col-sm-4 hidden-xs']/button[@class='btn btn-primary btn-block btn-outline']")).shouldHave(
                        text("Ответить")).click();
        $(By.xpath("//div/textarea")).shouldBe(visible).val("Hello World!").submit();
        Selenide.sleep(5000);
        $(By.xpath(
                "//div[@class='editor-footer']/button[contains(text(),'Отправить ответ')]")).shouldBe(
                        enabled).click();
        $(By.xpath("//div[@class='post-body']/article/p[contains(text(),'Hello World!')]")).isDisplayed();
        $(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Темы')]")).shouldBe(visible).click();
    }
}
