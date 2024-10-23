package demoqa.widgets;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.WidgetsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SelectTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).getWidgets().hideAds();
        new SidePage(app.driver).selectSelectMenu().hideAds();

    }

    @Test
    public void oldStyleSelectTest() {
        new WidgetsPage(app.driver)
                .selectOldStyle("Indigo");
    }

    @Test
    public void multiSelectTest() {
        String[] colorsSelect = {"Green", "Blue"};
        new WidgetsPage(app.driver).multiSelect(colorsSelect);
        //assertTrue(areColorsSelected(colorsSelect));
        assertTrue(new WidgetsPage(app.driver).areColorsSelected(colorsSelect));
    }

    @Test
    public void SelectOneCarTest() {
        String car = "Volvo";
        new WidgetsPage(app.driver)
                .selectedOneCar(car)
                .verifyIsOneCarSelected(car);
    }

    // Тест на выбор нескольких автомобилей
    @Test
    public void multiSelectCarsTest() {
        String[] cars = {"Volvo", "Audi"};  // Массив с автомобилями, которые нужно выбрать
        new WidgetsPage(app.driver)
                .multiCarSelect(cars)  // Выбираем автомобили из списка
                .verifyCarsSelected(cars);  // Проверяем, что автомобили выбраны корректно
    }

    //18.10.22
    //Метод который помогает выбирать автомобили по индексу
    @Test
    public void standartMultiSelectByIndexTest() {
        new WidgetsPage(app.driver)
                .standardMultiSelectByIndex(2)
        .verifyByIndex(2);
    }
    //ыбираем несколько автомобилей. Передаем массив автомобилей, которые нужно выбрать
@Test
    public void standardMultiSelectByCarsTest() {
        String[] cars = {"Volvo", "Opel","Saab"};
        new WidgetsPage(app.driver)
                .standardMultiSelectByCars(cars)
                .verifyMultiSelectByCars(cars);
    }

}










