import java.io.File;
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
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.*;

public class DisabledRegistrationTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  private JavascriptExecutor js;

  @Before
public void setUp() {
  String driverPath = "src/test/chromedriver/chromedriver.exe";
  File file = new File(driverPath);
  String absolutePath = file.getAbsolutePath();
  System.setProperty("webdriver.chrome.driver", absolutePath);
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
  public void disabledRegistration() {
    driver.get("http://127.0.0.1:7000/");
    driver.manage().window().setSize(new Dimension(974, 1040));
    driver.findElement(By.cssSelector(".hero__button")).click();
    driver.findElement(By.id("sign-up__first-name")).click();
    driver.findElement(By.id("sign-up__first-name")).sendKeys("Andrii");
    driver.findElement(By.id("sign-up__last-name")).click();
    driver.findElement(By.id("sign-up__last-name")).sendKeys("Psarov");
    driver.findElement(By.id("sign-up__password")).click();
    driver.findElement(By.id("sign-up__password")).sendKeys("gdfhderfh");
    driver.findElement(By.cssSelector(".form__button")).click();
    assertThat(driver.findElement(By.cssSelector(".form__row:nth-child(4) > .form__feedback")).getText(), is("Enter a valid email"));
  }
}
