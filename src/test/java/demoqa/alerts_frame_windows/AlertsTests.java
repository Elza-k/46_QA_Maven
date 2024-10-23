package demoqa.alerts_frame_windows;

import demoqa.core.TestBase;
import demoqa.pages.AlertsPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).getAlertsFrameWindows().hideAds();//первый шаг зайдет на страницу где горизонтальные иконки и выбираем 3 кнопку
        new SidePage(app.driver).selectAlerts().hideAds();//вторым шагом уже выбираем на иконку в боковой панели
    }
    @Test
    public void waitAlertsTest() {
        new AlertsPage(app.driver).clickalertWithTimer();
    }
    @Test
    //кнопка которую нажимаем после того как нажали на алерт
    public void alertWithSeectText() {
        new AlertsPage(app.driver)
                .clickOnConfirmButton()//кнопка klick me
                .selectResult("OK")//словие, что если мы передаем ок, то он должен согласиться с алертом, а если cancel-то он должен отреагировать
                .verifyResult("Ok");
    }
  //тестрируем кнопку для запроса promtButton
    @Test
    public void sendMessageAlert() {
        new AlertsPage(app.driver)
                .clickOnPromptButton()
                .sendTextToAlert("Hello")//отправляем текст нашему алерут
                .verifyAlertText("Hello");//проверяем текст и сравниваем с тем что в кавычках
    }
}
