package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TopicPage {

    public WebElement requestButton() {
        return $(By.xpath(
                "//div[@class='col-sm-4 hidden-xs']/button[@class='btn btn-primary btn-block btn-outline']")).shouldHave(
                text("Ответить"));
    }

    public WebElement textArea() {
        return $(By.xpath("//div/textarea")).shouldBe(visible);
    }

    public WebElement sendRequestButton() {
        return $(By.xpath("//div/button[text()='Отправить ответ']"));
    }

    public WebElement requestCheck() {
        return $(By.xpath("//div[@class='post-body']/article/p[contains(text(),'Hello World!')]"));
    }

    public WebElement themes() {
        Selenide.sleep(1000);
        return $(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Темы')]"));

    }
}
