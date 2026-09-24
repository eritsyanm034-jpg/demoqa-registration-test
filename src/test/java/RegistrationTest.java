import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;


public class RegistrationTest {

    @Test
    void fillRegistrationForm() {
        // Открываем страницу с формой
        open("https://demoqa.com/automation-practice-form");

        // Вводим имя
        $("[id=firstName]").setValue("Mariam");

        // Вводим фамилию
        $("[id=lastName]").setValue("Petrova");

        // Вводим email
        $("[id=userEmail]").setValue("mariam.petrova@example.com");

        // Вводим телефон 10 цифр
        $("[id=userNumber]").setValue("9999999999");

        // Выбираем пол Female
        $("label[for='gender-radio-2']").click();

        // Открываем календарь
        $("[id='dateOfBirthInput']").click();

        // Выбираем год
        $(".react-datepicker__year-select").selectOption("2000");

        // Выбираем месяц
        $(".react-datepicker__month-select").selectOption("May");

        // Выбираем дату
        $(".react-datepicker__day--015").click();

        // Вводим предмет
        $("[id=subjectsInput]").setValue("Maths").pressEnter();

        // Выбираем хобби
        $("[id='hobbies-checkbox-2']").click();

        // Загружаем фото
        $("[id=uploadPicture]").uploadFromClasspath("photo.png");

        // Вводим адрес
        $("[id=currentAddress]").setValue("10 Test Street");

        // Выбираем штат
        $("[id='react-select-3-input']").setValue("NCR").pressEnter();

        // Выбираем город
        $("[id='react-select-4-input']").setValue("Delhi").pressEnter();

        // Нажать кнопку Отправить
        $("[id='submit']").click();








        // Проверяем, что поля содержат введённые значения
        $("[id='firstName']").shouldHave(value("Mariam"));
        $("[id='lastName']").shouldHave(value("Petrova"));
        $("[id='userEmail']").shouldHave(value("mariam.petrova@example.com"));
        $("[id='userNumber']").shouldHave(value("9999999999"));
        $("[id='dateOfBirthInput']").shouldHave(value("15 May 2000"));
        $("[id='subjectsContainer']").shouldHave(text("Maths"));
        $("[id='hobbies-checkbox-2']").shouldBe(checked);
        $("[id='uploadPicture']").shouldHave(partialValue("photo.png"));
        $("[id='currentAddress']").shouldHave(value("10 Test Street"));
        $("[id='state']").shouldHave(text("NCR"));
        $("[id='city']").shouldHave(text("Delhi"));







    }
}