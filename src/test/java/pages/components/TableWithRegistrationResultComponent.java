package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TableWithRegistrationResultComponent {
    SelenideElement
            tableHeader = $("#example-modal-sizes-title-lg"),
            lineStudentName = $x("//tbody/tr[1]/td[2]"),
            lineStudentEmail = $x("//tbody/tr[2]/td[2]"),
            lineGender = $x("//tbody/tr[3]/td[2]"),
            lineMobile = $x("//tbody/tr[4]/td[2]"),
            lineDateBirth = $x("//tbody/tr[5]/td[2]"),
            lineSubjects = $x("//tbody/tr[6]/td[2]"),
            lineHobbies = $x("//tbody/tr[7]/td[2]"),
            linePicture = $x("//tbody/tr[8]/td[2]"),
            lineAddress = $x("//tbody/tr[9]/td[2]"),
            lineStateAndCity = $x("//tbody/tr[10]/td[2]"),
            buttonClose = $("#closeLargeModal");

    public TableWithRegistrationResultComponent clickClose() {
        buttonClose.click();

        return this;
    }

    public TableWithRegistrationResultComponent checkThatTheTableHasOpened() {
        tableHeader.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public TableWithRegistrationResultComponent checkResultRequiredFields(String firstName,
                                                                          String lastName,
                                                                          String gender,
                                                                          String number,
                                                                          String day,
                                                                          String month,
                                                                          String year) {
        lineStudentName.shouldHave(text(firstName + " " + lastName));
        lineStudentEmail.shouldBe(empty);
        lineGender.shouldHave(text(gender));
        lineMobile.shouldHave(text(number));
        lineDateBirth.shouldHave(text(day + " " + month + "," + year));
        lineSubjects.shouldBe(empty);
        lineHobbies.shouldBe(empty);
        linePicture.shouldBe(empty);
        lineAddress.shouldBe(empty);
        lineStateAndCity.shouldBe(empty);

        return this;
    }

    public TableWithRegistrationResultComponent checkResultAllFields(String firstName,
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
        tableHeader.shouldHave(text("Thanks for submitting the form"));
        lineStudentName.shouldHave(text(firstName + " " + lastName));
        lineStudentEmail.shouldHave(text(email));
        lineGender.shouldHave(text(gender));
        lineMobile.shouldHave(text(number));
        lineDateBirth.shouldHave(text(day + " " + month + "," + year));
        lineSubjects.shouldHave(text(subjects));
        lineHobbies.shouldHave(text(hobbies));
        linePicture.shouldHave(text(photo));
        lineAddress.shouldHave(text(address));
        lineStateAndCity.shouldHave(text(selectState + " " + selectCity));

        return this;
    }
}