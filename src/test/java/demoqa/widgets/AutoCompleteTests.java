package demoqa.widgets;

import demoqa.core.TestBase;
import demoqa.pages.AutoCompletePage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompleteTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).getWidgets().hideAds();
        new SidePage(app.driver).selectAutoCompleteMenu().hideAds();
    }

    @Test//подставляем один цвет поэтому single
    public void autoCompleteSingleTests() {
        new AutoCompletePage(app.driver)
                .autoComplete("m")
                .verifyAutoComplete("Magenta");
    }

    //тест в котором ередаем массив цветов
    @Test
    public void autoCompleteArrayTests() {
        String[] autoCompleteArray = new String[]{"m", "b"};
        String[] autoCompleteArrayVerify = {"Magenta", "Black"};//второй массив для сравнения c тем что выводится в поле после начала ввода буквы "m"
        new AutoCompletePage(app.driver)
                .autoCompleteArray(autoCompleteArray)
        .verifyAutoCompleteArray(autoCompleteArrayVerify);
    }
}