package pageobjects.pages;

import com.codeborne.selenide.SelenideElement;
import pageobjects.pages.components.CalendarComponent;
import pageobjects.pages.components.TableWithRegistrationResultComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage {
    CalendarComponent calendar = new CalendarComponent();
    SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateField = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityField = $("#city"),
            buttonSubmit = $("#submit");

    public StudentRegistrationFormPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public StudentRegistrationFormPage checkThatTheSiteHasOpened() {
        formTitle.shouldHave(text("Student Registration Form"));

        return this;
    }

    public StudentRegistrationFormPage closeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public StudentRegistrationFormPage setRequiredFields(String firstName,
                                                         String lastName,
                                                         String gender,
                                                         String number,
                                                         String day,
                                                         String month,
                                                         String year) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        genderWrapper.$(byText(gender)).click();
        userNumberInput.setValue(number);
        birthDateInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public StudentRegistrationFormPage setAllFields(String firstName,
                                                    String lastName,
                                                    String email,
                                                    String gender,
                                                    String number,
                                                    String day,
                                                    String month,
                                                    String year,
                                                    String subjects,
                                                    String hobbies,
                                                    String photo,
                                                    String address,
                                                    String selectState,
                                                    String selectCity) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        userEmailInput.setValue(email);
        genderWrapper.$(byText(gender)).click();
        userNumberInput.setValue(number);
        birthDateInput.click();
        calendar.setDate(day, month, year);
        subjectsInput.setValue(subjects).pressEnter();
        hobbiesWrapper.$(byText(hobbies)).click();
        uploadPicture.uploadFromClasspath(photo);
        currentAddress.setValue(address);
        stateField.click();
        stateCityWrapper.$(byText(selectState)).click();
        cityField.click();
        stateCityWrapper.$(byText(selectCity)).click();

        return this;
    }

    public TableWithRegistrationResultComponent clickSubmit() {
        buttonSubmit.click();

        return new TableWithRegistrationResultComponent();
    }
}
