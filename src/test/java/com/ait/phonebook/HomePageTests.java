package com.ait.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void OpenHomePageTest() {
// verify to displayed Home Component form
     //   isHomeComponentPresent();
      //  System.out.println("Home Component is " + isHomeComponentPresent());
      //  isHomeComponentPresent2();
     //   isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
     //   isElementPresent2(By.cssSelector("div:nth-child(2)>div>div"));
        Assert.assertTrue(isElementPresent2(By.cssSelector("div:nth-child(2)>div>div")));
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.cssSelector("div:nth-child(2)>div>div")).size()>0;
    }

  //  public boolean isElementPresent(By locator) {
   //     return driver.findElements(locator).size()>0;
  //  }

    public boolean isHomeComponentPresent2() {
        try {
            driver.findElement(By.cssSelector("div:nth-child(2)>div>div"));
            return  true;
        }catch (NoSuchElementException ex) {
            return false;
        }
    }

}
