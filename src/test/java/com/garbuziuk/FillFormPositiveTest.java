package com.garbuziuk;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillFormPositiveTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
       // Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest() {
        //Arrange
        open("/automation-practice-form");
        $("#firstName").setValue("Nikolay");
        $("#lastName").setValue("Garbuziuk");
        $("#userEmail").setValue("testemail@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--022").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src\\test\\resources\\fileForUpload.jpg"));
        $("#currentAddress").setValue("Test address");
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Merrut").pressEnter();
        //Act
        $("#submit").click();
        //Assert
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//table//tr[1]/td[2]").shouldHave(text("Nikolay Garbuziuk"));
        $x("//table//tr[2]/td[2]").shouldHave(text("testemail@gmail.com"));
        $x("//table//tr[3]/td[2]").shouldHave(text("Male"));
        $x("//table//tr[4]/td[2]").shouldHave(text("1234567890"));
        $x("//table//tr[5]/td[2]").shouldHave(text("22 February,1991"));
        $x("//table//tr[6]/td[2]").shouldHave(text("Maths"));
        $x("//table//tr[7]/td[2]").shouldHave(text("Sports"));
        $x("//table//tr[8]/td[2]").shouldHave(text("fileForUpload.jpg"));
        $x("//table//tr[9]/td[2]").shouldHave(text("Test address"));
        $x("//table//tr[10]/td[2]").shouldHave(text("Uttar Pradesh Merrut"));
    }
}
