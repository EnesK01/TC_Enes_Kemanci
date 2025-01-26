package PageModels;

import io.cucumber.java.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class HomePage {
    protected WebDriver driver;
     By company = By.xpath("(//*[contains(text(),'Company')])[1]");
     By careerUnderCompany=By.cssSelector("[href='https://useinsider.com/careers/']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void ChooseOptionsForCareerPage(){
        driver.findElement(company).click();
        driver.findElement(careerUnderCompany).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
