package demoqa.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();//ссылка по которой мы можем достучаться до ApplicationManager. Вместо extends...

    @BeforeMethod
    public void setUp() {
        app.init();//init инициализирует наш драйвер
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        app.stop();//метод который останавливает наш драйвер
    }

}



