package workshop;

import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkTest extends BaseTest {

    @Test
    public void testClickingOnAllLinks() {
        driver.get("https://men-men-s-01.codersguru.pl/");
        HomePage homePage = new HomePage(driver);

        homePage.clickOnLinks();

        //sprawdzenie ostatniej strony
        String parentHandle = driver.getWindowHandle();
        homePage.clickOnLinkOpeningNewWindow();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (String popupHandle: driver.getWindowHandles()) {
            driver.switchTo().window(popupHandle);

        }

        assertTrue(driver.getTitle().contains("Coders"));
        driver.close();
        driver.switchTo().window(parentHandle);


    }

}