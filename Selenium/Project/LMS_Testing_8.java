import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LMS_Testing_8 {
    WebDriver driver;
    @BeforeTest                                                                           //Opens the website
    public void beforeMethod(){
        driver = new FirefoxDriver();                                                   //Instance for Firefox driver
        driver.get("https://alchemy.hguy.co/lms");                                      //Opens the website
    }
    @Test
    public void testcase8(){                                                           //8.Contact the admin
        driver.findElement(By.linkText("Contact")).click();

        WebElement FullName = driver.findElement(By.id("wpforms-8-field_0"));
        FullName.sendKeys("Sindhuja Ravichandran");

        WebElement Email = driver.findElement(By.id("wpforms-8-field_1"));
        Email.sendKeys("sindhujaravichandran.04@gmail.com");

        WebElement Comment = driver.findElement(By.id("wpforms-8-field_2"));
        Comment.sendKeys("Testing");

        driver.findElement(By.id("wpforms-submit-8")).click();

        WebElement Confirmation = driver.findElement(By.id("wpforms-confirmation-8"));
        System.out.println(Confirmation.getText());

    }
    @AfterTest
    public void afterMethod(){
        driver.close();                                                              //Closes the browser
    }
}
