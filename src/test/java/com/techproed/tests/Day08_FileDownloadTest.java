package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileDownloadTest extends TestBase {


    @Test
    public void fileDownloadTest() throws InterruptedException {
        //        Create a class:FileDownloadTest
        //        fileDownloadTest()
        //        Go to https://the-internet.herokuapp.com/download

        driver.get("https://the-internet.herokuapp.com/download");
        //        Download flower.png file
        driver.findElement(By.linkText("flower.jpeg")).click();

        //        Then verify if the file downloaded successfully

        //We must put hard wait since file download takes a little time
        //Implicit or explicit wait cannot fix the problem, because download folder is windows based application
        Thread.sleep(2000);

        //Getting the PATH of the HOME directory with JAVA
        String homePath = System.getProperty("user.home");
        //This will be the file name that is downloaded
        String pathOfFlower = homePath + "/Downloads/flower.jpeg";

        boolean isDownloaded = Files.exists(Paths.get(pathOfFlower));
        //Asserting if file download is successful
        Assert.assertTrue(isDownloaded);



    }



}
