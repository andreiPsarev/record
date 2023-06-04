import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

public class SuccessfulRegistrationTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  private JavascriptExecutor js;

  @Before
  public void setUp() {
    String driverPath = "./chromedriver/chromedriver.exe";
    System.setProperty("webdriver.chrome.driver", driverPath);
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    driver = new ChromeDriver(options);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @After
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Test
  public void successfulRegistration() {
    driver.get("http://127.0.0.1:7000/");
    driver.manage().window().setSize(new Dimension(974, 1040));
    driver.findElement(By.cssSelector(".hero__button")).click();
    driver.findElement(By.id("sign-up__first-name")).click();
    driver.findElement(By.id("sign-up__first-name")).sendKeys("Andrei");
    driver.findElement(By.id("sign-up__last-name")).sendKeys("Psarev");
    driver.findElement(By.id("sign-up__email")).sendKeys("psarevandrej327@gmail.com");
    driver.findElement(By.id("sign-up__password")).click();
    driver.findElement(By.id("sign-up__password")).sendKeys("Fylhtq2001!");
    driver.findElement(By.id("sign-up__confirm-password")).click();
    driver.findElement(By.id("sign-up__confirm-password")).sendKeys("Fylhtq2001!");
    driver.findElement(By.cssSelector(".form__button")).click();
    driver.findElement(By.cssSelector(".alert__button")).click();
  }
}
