package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentHelper.*;
import static io.qameta.allure.Allure.step;

public class ProjectWithJavaFaker extends TestBase {

    PageObjects po = new PageObjects();

    @Test
    void selenideSearchTest() {

        step("Открываем сайт", () -> {
           po.openPage();
        });
        step("Заполняем форму", () -> {
            po.fillForm();
        });
        step("Валидируем данные", () -> {
            po.checkData();
        });

    }
}