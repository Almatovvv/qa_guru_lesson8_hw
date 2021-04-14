package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PageObjects {

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),

    lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.number().digits(10),
            subjectsInput = "Maths",
            currentAddress = faker.address().streetAddress(),
            userState = "NCR",
            userCity = "Delhi",
            monthSelect = "June",
            yearSelect = "1969";

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void fillForm() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $x("//label[contains(text(),'Other')]").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $x("//select[@class='react-datepicker__month-select']").selectOption(monthSelect);
        $x("//select[@class='react-datepicker__year-select']").selectOption(yearSelect);
        $x("//div[@aria-label='Choose Tuesday, June 10th, 1969']").click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $x("//label[contains(text(),'Sports')]").click();
        $("#uploadPicture").scrollTo().uploadFile(new File("src/test/resources/Test.jpg"));
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(userState).pressEnter();
        $("#react-select-4-input").setValue(userCity).pressEnter();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    }

    public void checkData() {
        $(By.xpath("//div[@class=\"table-responsive\"]")).shouldHave(
                text(firstName + " " + lastName),
                text(userEmail),
                text("Other"),
                text(userNumber),
                text("10 June,1969"),
                text(subjectsInput),
                text("Sports"),
                text("Test.jpg"),
                text(currentAddress),
                text(userState + " " + userCity));

    }
}
