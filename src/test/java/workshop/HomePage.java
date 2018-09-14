package workshop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HomePage extends BasePage {

    //lokatory są private:
    @FindBy (name="email")
    private WebElement emailTextBox; //to samo co:
    // private WebElement emailTextBox = driver.findElement(By.name("email"));

    @FindBy (xpath="/html/body/section[1]/div/div[1]/a/img")
    private WebElement homePageLink;

    @FindBy (xpath="/html/body/section[1]/div/div[2]/nav/ul/li[1]/a")
    private WebElement howItWorksLink;

    @FindBy (xpath="/html/body/section[1]/div/div[2]/nav/ul/li[2]/a")
    private WebElement pricelist;

    @FindBy (xpath="/html/body/section[1]/div/div[2]/nav/ul/li[3]/a")
    private WebElement beAMentor;

    @FindBy (name="button")
    private WebElement logInButton;

    @FindBy (xpath="/html/body/section[3]/div/form/input[2]")
    private WebElement registerButton;


    @FindBy (xpath="/html/body/footer/div/div[1]/a[1]")
    private WebElement regulations;

    @FindBy (xpath="/html/body/footer/div/div[1]/a[2]")
    private WebElement howItWorksButtom;


    @FindBy (xpath="/html/body/footer/div/div[2]/a/img")
    private WebElement fb;



    @FindBy (xpath="/html/body/footer/div/legal/a")
    private WebElement codersLab;

    //konstruktor dziedziczony z klasy BasePage:
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //dostęp do lokatorów gwarantuje metoda public
    public void enterEmail(String email) {
        this.emailTextBox.clear();
        this.emailTextBox.sendKeys(email);
    }

    WebElement[] linkList = new WebElement[]{homePageLink, howItWorksLink, pricelist, beAMentor, logInButton, registerButton, regulations, howItWorksButtom, fb};

    public void clickOnLinks() {
        for (WebElement s: linkList) {
            s.click();

            String title = driver.getTitle();
            assertTrue(title.contains("Coders"));
            assertFalse(title.contains("Error"));

            driver.navigate().back();
        }
    }

    public void clickOnLinkOpeningNewWindow() {
        this.codersLab.click();
    }







}
