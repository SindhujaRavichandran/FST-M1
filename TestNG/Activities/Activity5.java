package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;

    @BeforeClass (alwaysRun = true)
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test (groups = {"HeaderTests", "ButtonTests"})
    public void pageTitleTest(){
        String Title = driver.getTitle();
        System.out.println("Page Title: " + Title);
        Assert.assertEquals(Title, "Target Practice");
    }

    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})
    public void headerTest1(){
        WebElement header3 = driver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(header3.getText(), "Third header");
    }

    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})
    public void headerTest2(){
        WebElement header5 = driver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(header5.getCssValue("Color"), "rgb(251, 189, 8)");
    }

    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})
    public void buttonTest1(){
        WebElement button1 = driver.findElement(By.cssSelector("button.olive"));
        Assert.assertEquals(button1.getText(), "Olive");
    }

    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})
    public void buttonTest2(){
        WebElement button2 = driver.findElement(By.cssSelector("button.brown"));
        Assert.assertEquals(button2.getCssValue("Color"), "rgb(255, 255, 255)");
    }

    @AfterClass (alwaysRun = true)
    public void afterClass(){
        driver.close();
    }
}
