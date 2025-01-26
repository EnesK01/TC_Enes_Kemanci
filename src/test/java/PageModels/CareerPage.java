package PageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CareerPage{
    protected WebDriver driver;
    private static final Logger logger= LoggerFactory.getLogger(CareerPage.class);
    String[] titles={"Our Locations","See all teams","Life at Insider"};
    By findYourDreamJob=By.xpath("//*[@class='btn btn-info rounded mr-0 mr-md-4 py-3']");

    public CareerPage(WebDriver driver) {
        this.driver=driver;

    }
    public void CareerPageIsCheckingByElementsExisting(){
        for (int i =0;i<titles.length;i++){
            if(driver.findElement(By.xpath("//*[contains(text(),'"+titles[i]+"')]")).isDisplayed()){
            logger.info(titles[i]+" elementi görüldü");

            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
