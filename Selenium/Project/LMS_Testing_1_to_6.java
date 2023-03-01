import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LMS_Testing_1_to_6 {
    WebDriver driver;
    @BeforeTest                                                                           //Opens the website
    public void beforeMethod(){
         driver = new FirefoxDriver();                                                   //Instance for Firefox driver
         driver.get("https://alchemy.hguy.co/lms");                                      //Opens the website
      }
    @Test
    public void testcase1(){                                                            //1.Website title verification
        String Title = driver.getTitle();                                              //Gets the title
        System.out.println("Title of the LMS Website: " + Title);                   //Prints the title
        Assert.assertEquals(Title, "Alchemy LMS – An LMS Application");        //Compares the title
    }
    @Test
    public void testcase2(){                                                           //2.WebPage Heading verification
        String Heading = driver.findElement(By.className("uagb-ifb-title")).getText(); //Gets the Heading
        System.out.println("Heading of the LMS Webpage: " + Heading);                  //Prints the Heading
        Assert.assertEquals(Heading, "Learn from Industry Experts");           //Compares the Heading
    }
    @Test
    public void testcase3(){                                                              //3.First Info Box-Title Verification
        WebElement InfoBoxTitle = driver.findElement(By.tagName("h3"));
        System.out.println("Title of the First Info Box: " + InfoBoxTitle.getText());
        Assert.assertEquals(InfoBoxTitle.getText(), "Actionable Training");
    }
    @Test
    public void testcase4(){                                                          //4.Second Popular Course Name verification
        WebElement SecondPopularCourse = driver.findElement(By.xpath("//*[@id='post-71']/div[2]/h3"));
        System.out.println("Second Popular Course in LMS: " + SecondPopularCourse.getText());
        Assert.assertEquals(SecondPopularCourse.getText(), "Email Marketing Strategies");
    }
    @Test
    public void testcase5(){                                                            //5.Navigation to another page
        driver.findElement(By.linkText("My Account")).click();
        String AnotherPage_Navigation = driver.getTitle();
        System.out.println("Title of My Account page: " + AnotherPage_Navigation);
        Assert.assertEquals(AnotherPage_Navigation,"My Account – Alchemy LMS");
    }
    @Test
    public void testcase6() {                                                           //6.Logging into the site
        driver.findElement(By.linkText("My Account")).click();

        driver.findElement(By.xpath("//a[@href='#login']")).click();

        WebElement UserName = driver.findElement(By.id("user_login"));
        UserName.sendKeys("root");

        WebElement Password = driver.findElement(By.id("user_pass"));
        Password.sendKeys("pa$$w0rd");

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        int VerifyLogin = driver.findElements(By.partialLinkText("Your Courses")).size();

    }
    @AfterTest
    public void afterMethod(){
        driver.close();                                                              //Closes the browser
    }
}
