package com.techproed.homework;

import com.techproed.utilities.TestBase;
import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class AmazonDropdown extends TestBase {
    //            Create A Class: AmazonDropdown
    @Test
    public void dropdownTest () {

    //            Create A Method dropdownTest
        boolean isAppAnOption = false;
        boolean isAlpOrder = true;
        boolean isAlpOrder2 = false;
        char firstcharacter = 'A';
        driver.get("https://www.amazon.com/");
        //            Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);
        List <WebElement> dropdownlist = select.getOptions();
        List <String > dropdownstring = new ArrayList<>();
        //            Print the first selected option and assert if it equals “All Departments”
        Assert.assertEquals("All Departments",dropdownlist.get(0).getText() );
        //            Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
        select.selectByIndex(3);
        //         (after you select you need to use get first selected option method)
        Assert.assertEquals("Baby", select.getFirstSelectedOption().getText());
        //        Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
        for (WebElement w : dropdownlist) {
            System.out.println(w.getText());
            dropdownstring.add(w.getText());
        }
        //     Print the the total number of options in the dropdown
        System.out.println(dropdownlist.size());
        //            Check if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
        for (WebElement w: dropdownlist) {
            if (w.getText().equals("Automotive")) {
                isAppAnOption = true ;
            }
        }

        System.out.println("Is Appliances is an option ? " + isAppAnOption);
        //            BONUS: Check if the dropdown is in Alphabetical Order
        //1.way:
        for (WebElement w: dropdownlist) {

            if (w.getText().charAt(0)<firstcharacter) {
                isAlpOrder = false;
            }
            firstcharacter = w.getText().charAt(0);
        }
        //2.way
        List <String> inOrderList = new ArrayList<>(dropdownstring);
        Collections.sort(inOrderList);

        if(dropdown.equals(inOrderList)) {
            isAlpOrder2 = true;
        }

        System.out.println("The list is alphatic order ? " + isAlpOrder);
        System.out.println("The list is alphatic order ? " + isAlpOrder2);



    }

}
