package demoqa.book_store;

import demoqa.core.TestBase;
import demoqa.pages.BookStorePage;
import demoqa.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase {
    @BeforeMethod

    public void preconditions() {
        new HomePage(app.driver).getBookStore().hideAds();//первый шаг зайдет на бук сторе

    }

    @Test
    public void searchBookTest() {
        String bookName = "Java";//обьявили локальную переменную
        new BookStorePage(app.driver)
                .typeInSearchFieldInput(bookName)
                .verifyText(bookName);

    }
}

