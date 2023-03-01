import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class LMS_Testing_7 {
    WebDriver driver;
    @BeforeTest                                                                           //Opens the website
    public void beforeMethod(){
        driver = new FirefoxDriver();                                                   //Instance for Firefox driver
        driver.get("https://alchemy.hguy.co/lms");                                      //Opens the website
    }
    @Test
    public void testcase7(){                                                           //7.Count the number of courses
        driver.findElement(By.linkText("All Courses")).click();
        List<WebElement>course_count = driver.findElements(By.className("ld_course_grid_button"));
        System.out.println("Number of courses on the page: " + course_count.size());
    }
    @AfterTest
    public void afterMethod(){
        driver.close();                                                              //Closes the browser
    }
}

