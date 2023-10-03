package pageobjects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageobjects.pages.StudentRegistrationFormPage;
import pageobjects.pages.components.TableWithRegistrationResultComponent;

import static io.qameta.allure.Allure.step;

@DisplayName("Student registration form test")
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
    TableWithRegistrationResultComponent tableWithRegistrationResultComponent = new TableWithRegistrationResultComponent();


    @Test
    @Tag("remote")
    @DisplayName("Successful registration")
    void successfulRegistrationWithRequiredFieldsTest()  {
        step("Opening a web page", () ->{
                    studentRegistrationForm
                            .openPage()
                            .checkThatTheSiteHasOpened()
                            .closeBanners();
                });
        step("Filling in required fields", () ->{
            studentRegistrationForm
                    .setRequiredFields(firstName,
                            lastName,
                            gender,
                            number,
                            day,
                            month,
                            year)
                    .clickSubmit();
        });
        step("Checking completed fields", () ->{
            tableWithRegistrationResultComponent
                    .checkThatTheTableHasOpened()
                    .checkResultRequiredFields(firstName,
                            lastName,
                            gender,
                            number,
                            day,
                            month,
                            year)
                    .clickClose();
        });
    }

    @Test
    @Tag("remote")
    @DisplayName("Successful registration with all fields")
    void successfulRegistrationWithAllFieldsTest() {
        step("Opening a web page", () ->{
            studentRegistrationForm
                    .openPage()
                    .checkThatTheSiteHasOpened()
                    .closeBanners();
        });
        step("Filling in all fields", () ->{
            studentRegistrationForm
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
                    .clickSubmit();
        });
        step("Checking completed fields", () ->{
            tableWithRegistrationResultComponent
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
        });
    }
}
