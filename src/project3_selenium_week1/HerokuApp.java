package project3_selenium_week1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/**
 * Project-3 - ProjectName : com-herokuapp
 * BaseUrl = http://the-internet.herokuapp.com/login 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field. 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Refresh the page.
 * 11. Close the browser.
 */
public class HerokuApp {
    static String browser = "Chrome";  //setting browser
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;   //declaring webdriver interface

    public static void main(String[] args) {
        //checking for multiple browsers to launch
        if (browser.equalsIgnoreCase("Chrome")){
            driver =  new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("wrong browser name");
        }

        //launching url
        driver.get(baseUrl);
        //maximize window
        driver.manage().window().maximize();
        //setting Implicit wait to driver until page is fully loaded
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //printing website title on console
        System.out.println("Title of website is: " + driver.getTitle());
        //printing current URL
        System.out.println("The current URL is: " + driver.getCurrentUrl());
        //printing page source
        System.out.println("The page source is: " + driver.getPageSource());

        //Entering email id on email field element
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Entering password on password field element
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //Clicking on login button element
        driver.findElement(By.className("radius")).click();

        //printing current URL
        System.out.println(driver.getCurrentUrl());
        //Refreshing page
        driver.navigate().refresh();

        driver.quit();  //to close browser

    }
}
