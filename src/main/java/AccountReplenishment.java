import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.time.Duration;

public class AccountReplenishment {

    @Test
    public void testAccountReplenishment()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        var phoneNumber = By.xpath("//*[@data-qa-node='phone-number']");
        var amount = By.xpath("//*[@data-qa-node='amount']");
        var numberdebitSource = By.xpath("//*[@data-qa-node='numberdebitSource']");
        var expiredebitSource = By.xpath("//*[@data-qa-node='expiredebitSource']");
        var cvvdebitSource = By.xpath("//*[@data-qa-node='cvvdebitSource']");
        var submit = By.xpath("//*[@data-qa-node='submit']");
        var phoneCode = By.xpath("//*[@data-qa-node='phone-code']");
        var phoneCodeList = By.xpath("//*[@data-qa-node='phone-code-list']/div/div/div/div/div[2]/div/input");
        var phoneCodeOption = By.xpath("//button[@data-qa-value='Україна'][@data-qa-node='phone-code-option']");
        var firstNamedebitSource = By.xpath("//*[@data-qa-node='firstNamedebitSource']");
        var lastNamedebitSource = By.xpath("//*[@data-qa-node='lastNamedebitSource']");

        var amountAssertion = By.xpath("//div[@data-qa-node='amount']");
        var cardAssertion = By.xpath("//td[@data-qa-node='card']");
        var detailsAssertion = By.xpath("//div[@data-qa-node='details']");

        driver.get("https://next.privat24.ua/mobile");

        driver.findElement(phoneCode).click();
        driver.findElement(phoneCodeList).sendKeys("Uk");
        driver.findElement(phoneCodeOption).click();
        driver.findElement(phoneNumber).sendKeys("978166120");
        driver.findElement(amount).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(amount).sendKeys("70");
        driver.findElement(numberdebitSource).sendKeys("4004159115449003");
        driver.findElement(expiredebitSource).sendKeys("1129");
        driver.findElement(cvvdebitSource).sendKeys("123");
        driver.findElement(firstNamedebitSource).sendKeys("Vasia");
        driver.findElement(lastNamedebitSource).sendKeys("Kachur");
        driver.findElement(submit).click();

        Assertions.assertEquals(driver.findElement(amountAssertion).getText(), "70 UAH");
        Assertions.assertEquals(driver.findElement(cardAssertion).getText(), "4004 **** **** 9003");
        Assertions.assertTrue(driver.findElement(detailsAssertion).getText().contains("+380978166120"));
    }
}
