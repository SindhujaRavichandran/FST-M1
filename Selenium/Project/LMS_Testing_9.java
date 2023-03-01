import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LMS_Testing_9 {
    WebDriver driver;

    @BeforeTest                                                                           //Opens the website
    public void beforeMethod() {
        driver = new FirefoxDriver();                                                   //Instance for Firefox driver
        driver.get("https://alchemy.hguy.co/lms");                                      //Opens the website

    }

    @Test
    public void testcase9() {                                                          //9.Complete a simple lesson
        driver.findElement(By.linkText("All Courses")).click();
        driver.findElement(By.cssSelector("img[src='https://alchemy.hguy.co/lms/wp-content/uploads/2016/12/course-3-free-img-400x223.jpg']")).click();
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.xpath("//a[@href='#login']")).click();
        WebElement UserName = driver.findElement(By.id("user_login"));
        UserName.sendKeys("root");

        WebElement Password = driver.findElement(By.id("user_pass"));
        Password.sendKeys("pa$$w0rd");

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.findElement(By.linkText("Email Marketing Strategies")).click();

        driver.findElement(By.linkText("Deliverability Of Your Emails")).click();
        String PageTitle = driver.getTitle();
        System.out.println("Page Title:" + PageTitle);

    }
    @AfterTest
    public void afterMethod(){
        driver.close();                                                              //Closes the browser
    }
}
