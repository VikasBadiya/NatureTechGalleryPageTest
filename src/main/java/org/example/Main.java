package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qanaturegallery.ccbp.tech/");

        //Print the Heading text.
        String HeadingText = driver.findElement(By.xpath("/html/body/section[1]/h1")).getText();
        System.out.println(HeadingText);

        //Perform the following actions in all <iframe> elements - use index to switch,
        ArrayList<WebElement> ElementList = new ArrayList<>(driver.findElements(By.tagName("iframe")));
        System.out.println(ElementList.size());
        for (WebElement element : ElementList) {
            driver.switchTo().frame(element);
            //Print the Heading text.
            String HeadingEleText = driver.findElement(By.tagName("h2")).getText();
            System.out.println(HeadingEleText);

            //Print the Description text.
            String DescriptionEleText = driver.findElement(By.tagName("p")).getText();
            System.out.println(DescriptionEleText);

            //Switch back to the main window (in order to switch to other iframes)
            driver.switchTo().parentFrame();

        }



        //Close the browser window.
        driver.quit();


    }
}