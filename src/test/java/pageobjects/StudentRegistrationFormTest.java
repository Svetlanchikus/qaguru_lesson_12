package pageobjects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageobjects.pages.StudentRegistrationFormPage;


public class StudentRegistrationFormTest extends TestBase{
    public String firstName = "Petr";
    public String lastName = "Petrov";
    public String email = "Pert@mail.com";
    public String gender = "Male";
    public String number = "1223456789";
    public String month = "March";
    public String year = "1917";
    public String day = "15";
    public String subjects = "Arts";
    public String hobbies = "Music";
    public String photo = "photo_1.png";
    public String address = "The city of Moscow";
    public String selectState = "NCR";
    public String selectCity = "Delhi";

    StudentRegistrationFormPage studentRegistrationForm = new StudentRegistrationFormPage();


    @Test
    @Tag("remote")
    @DisplayName("Successful registration")
    void successfulRegistrationWithRequiredFieldsTest()  {
        studentRegistrationForm
                .openPage()
                .checkThatTheSiteHasOpened()
                .closeBanners()
                .setRequiredFields(firstName,
                        lastName,
                        gender,
                        number,
                        day,
                        month,
                        year)
                .clickSubmit()
                .checkThatTheTableHasOpened()
                .checkResultRequiredFields(firstName,
                        lastName,
                        gender,
                        number,
                        day,
                        month,
                        year)
                .clickClose();
    }

    @Test
    @Tag("remote")
    @DisplayName("Successful registration with all fields")
    void successfulRegistrationWithAllFieldsTest() {
        studentRegistrationForm
                .openPage()
                .checkThatTheSiteHasOpened()
                .closeBanners()
                .setAllFields(firstName,
                        lastName,
                        email,
                        gender,
                        number,
                        day,
                        month,
                        year,
                        subjects,
                        hobbies,
                        photo,
                        address,
                        selectState,
                        selectCity)
                .clickSubmit()
                .checkThatTheTableHasOpened()
                .checkResultAllFields(firstName,
                        lastName,
                        email,
                        gender,
                        number,
                        day,
                        month,
                        year,
                        subjects,
                        hobbies,
                        photo,
                        address,
                        selectState,
                        selectCity)
                .clickClose();
    }
}
