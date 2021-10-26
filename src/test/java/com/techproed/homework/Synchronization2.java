package com.techproed.homework;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Synchronization2 extends TestBase {

    /*
            Create a class:Synchronization2. Create a method: isEnabled
            Go to https://the-internet.herokuapp.com/dynamic_controls
            Click enable Button
            And verify the message is equal to “It's enabled!”
            And verify the textbox is enabled (I can type in the box)
            And click on Disable button
            And verify the message is equal to “It's disabled!”
            And verify the textbox is disabled (I cannot type in the box)
     */
    @Test
    public void isEnabled() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();

        Thread.sleep(5000);

        Assert.assertEquals("It's enabled!",driver.findElement(By.id("message")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isEnabled());

        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();

        Thread.sleep(5000);

        Assert.assertFalse(driver.findElement(By.xpath("//input[@type='text']")).isEnabled());



    }
}
