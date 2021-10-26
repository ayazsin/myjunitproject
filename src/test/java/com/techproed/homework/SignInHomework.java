package com.techproed.homework;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SignInHomework {

    //ENTER ALL REQUIRED FIELDS AND VERIFY THE ACCOUNT CREATION IS SUCCESSFUL

    WebDriver driver;
    Faker faker = new Faker();
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void signInHomework() {
        //2. Go to http://automationpractice.com/index.php
        driver.get("http://automationpractice.com/index.php");
        //3. Click on sign in link
        driver.findElement(By.linkText("Sign in")).click();
        //4. Send your email and click on create an account button.
        //   We will use that email. Make sure to save that email.
        //   If the email is already used for account creation you can not use it again
        String email = faker.internet().emailAddress();
        driver.findElement(By.id("email_create")).sendKeys(email);

        //5. Verify the Text : CREATE AN ACCOUNT
        WebElement actualLinkText = driver.findElement(By.id("SubmitCreate"));
        String expectedLinkText = "Create an account";
        Assert.assertEquals(expectedLinkText,actualLinkText.getText());

        //Click Create an account
        actualLinkText.click();

        //6. Verify the Text : YOUR PERSONAL INFORMATION
        String expectedHeading = "YOUR PERSONAL INFORMATION";
        String actualHeading = driver.findElement(By.xpath("//*[@id='account-creation_form']/div[1]/h3")).getText();
        Assert.assertEquals(expectedHeading,actualHeading);

        //8. Select your title
        driver.findElement(By.id("id_gender2")).click();
        //7. Verify the Text : Title
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='id_gender2']")).isSelected());

        //9. Enter your first name
        String firstName = faker.name().firstName();
        driver.findElement(By.id("customer_firstname")).sendKeys(firstName);

        //10. Enter your last name
        String lastName = faker.name().lastName();
        driver.findElement(By.id("customer_lastname")).sendKeys(lastName);

        //12. Enter your password
        driver.findElement(By.id("passwd")).sendKeys(faker.internet().password());

        //13. ENTER DATE OF BIRTH
        WebElement days = driver.findElement(By.xpath("//select[@id='days']"));
        Select select = new Select(days);
        select.selectByIndex(1);

        WebElement months = driver.findElement(By.id("months"));
        Select select1 = new Select(months);
        select1.selectByIndex(10);

        WebElement years = driver.findElement(By.id("years"));
        Select select2 = new Select(years);
        select2.selectByValue("1985");

        //14. Click on Sign up for our newsletter!
        driver.findElement(By.id("uniform-newsletter")).click();

        //15. Enter your first name
        driver.findElement(By.id("firstname")).sendKeys(firstName);

        //16. Enter your last lane
        driver.findElement(By.id("lastname")).sendKeys(lastName);

        //18. Enter your Address
        driver.findElement(By.id("address1")).sendKeys("Street address, P.O. Box, Company name, etc.");

        //19. Enter your City
        driver.findElement(By.id("city")).sendKeys(faker.address().city());

        //20. SELECT STATE
        WebElement states = driver.findElement(By.id("id_state"));
        Select select3 = new Select(states);
        select3.selectByVisibleText("Nevada");

        //21. Enter Postal Code
        driver.findElement(By.id("postcode")).sendKeys("12000");

        //25. Enter mobile phone
        driver.findElement(By.id("phone_mobile")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.id("alias")).sendKeys("Street address");
        driver.findElement(By.id("submitAccount")).click();










    }

}
