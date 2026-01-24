package pages;


import base.DriverManager;
import org.openqa.selenium.By;

public class GoogleHomePage {

    private final By searchBox = By.name("q");

    public void open() {
        DriverManager.getDriver().get("https://www.google.com");
    }

    public void search(String text) {
        DriverManager.getDriver().findElement(searchBox).sendKeys(text);
    }
}


