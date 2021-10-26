package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day08_FileUploadTest extends TestBase {

    @Test
    public void fileUploadTest() throws InterruptedException {

        //        Class Name: FileUploadTest
        //        Method Name: fileUploadTest
        //        When user goes to https://the-internet.herokuapp.com/upload

        driver.get("https://the-internet.herokuapp.com/upload");


        //        When user selects an image from the desktop

        //Choose File button
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

        //Getting the PATH of the HOME directory with JAVA
        String homePath = System.getProperty("user.home"); // /Users/techproed/Desktop/flower.jpeg
        String pathOfFlower = homePath+"/Downloads/flower.jpeg";

        Thread.sleep(5000);

        //Sending the path of flower to the button
        chooseFileButton.sendKeys(pathOfFlower);

        Thread.sleep(5000);
        //        And click on the upload button
        driver.findElement(By.id("file-submit")).click();

        //        Then verify the File Uploaded!  Message displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='File Uploaded!']")).getText().equals("File Uploaded!"));

        /*
         * In selenium, we have limitation with working with windows
         * We can use JAVA to locate the path of a file
         * Then use sendKeys method to send the path to the button element
         * This will upload the file to the webpage
         * */




    }
}
