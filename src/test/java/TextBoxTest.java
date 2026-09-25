import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {

    @Test
    void shouldSubmitWithNameOnly() {
        // Откроем страницу формы
        open("https://demoqa.com/text-box");

        // Введем имя
        $("[id='userName']").setValue("Fredi Petrov");

        // Нажмем кнопку Submit
        $("[id='submit']").scrollIntoCenter().click();

        // Проверяем, что поля содержат введённые значения
        $("[id='output'] [id='name']").shouldBe(visible).shouldHave(exactText("Name:Fredi Petrov"));
    }
    @Test
    void shouldRejectInvalidEmail() {
        // Откроем страницу формы
        open("https://demoqa.com/text-box");

        // Введем имя
        $("[id='userName']").setValue("Fredi Petrov");

        // Вводим неправильный email
        $("[id='userEmail']").setValue("fredi.example.com");

        // Нажмем кнопку Submit
        $("[id='submit']").scrollIntoCenter().click();

        // Проверяем, что поле email отмечено ошибкой
        $("[id='userEmail']").shouldHave(cssClass("field-error"));

        // Проверяем, что строки результата не появились
        $("[id='output'] p").shouldNot(exist);

    }

}