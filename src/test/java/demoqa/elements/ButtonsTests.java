package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.ButtonsPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).getElements().hideAds();
        new SidePage(app.driver).selectButtons().hideAds();
    }

    @Test
    public void doubleClickButtonsTest() {
        new ButtonsPage(app.driver)
                .doubleClick()
                .verifyDoubleClickMessage("You have done a double click");//проверим сообщение которое появляется после двйного клика
    }

    @Test
    public void rightClickButtonsTest() throws InterruptedException {
        new ButtonsPage(app.driver)
                .rightClick()
                .verifyRightClickMessage("You have done a right click");//проверим сообщение которое появляется после двйного клика
    }
    @Test(invocationCount = 2)
    public void dynamicClickButtonsTest() throws InterruptedException {
        new ButtonsPage(app.driver)
                .dynamicClickButton()
                .verifyDynamicClickMessage("You have done a dynamic click");//проверим сообщение которое появляется после двйного клика
    }
}
