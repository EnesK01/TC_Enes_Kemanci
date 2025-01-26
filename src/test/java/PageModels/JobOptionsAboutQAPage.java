package PageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class JobOptionsAboutQAPage {
    protected WebDriver driver;
    private static final Logger logger= LoggerFactory.getLogger(JobOptionsAboutQAPage.class);

    By chooseLocation=By.xpath("(//span[@id='select2-filter-by-location-container'])[1]");
    By department=By.xpath("(//span[@class='select2-selection__arrow'])[2]");
    By IstanbulLocation=By.xpath("(//*[@class='select2-results__option'])[1]");
    By departmentOfQA=By.xpath("(//*[@class='select2-results__option'])[11]");
    By ViewRoleButton=By.xpath("(//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5'])[1]");
    JavascriptExecutor executor;
    Actions actions;
    public JobOptionsAboutQAPage(WebDriver driver){
        this.driver=driver;
        executor=(JavascriptExecutor) driver;
        actions=new Actions(driver);
    }
    public void ChooseLocation() {

        executor.executeScript("window.scrollBy(0,500)", "");
        for(int i=0;i<3;i++){
            try {

                WebElement filterElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@id='select2-filter-by-location-container'])[1]")));
                filterElement.click();
                WebElement istanbulElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='select2-results__option'])[1]")));
                istanbulElement.click();

            } catch (Exception e) {
                System.out.println("Filtre veya İstanbul seçeneğiyle ilgili hata oluştu: " + e.getMessage());
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(department).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(departmentOfQA).click();


    }
    public void CheckJoblistAndPositions() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> joblist = driver.findElements(By.xpath("(//div[@id='jobs-list'])/div"));
        List<WebElement> jobTitle = driver.findElements(By.xpath("(//div[@id='jobs-list'])/div/div/p"));
        List<WebElement> departmanTitle=driver.findElements(By.xpath("(//div[@id='jobs-list'])/div/div/span"));
        List<WebElement> LocationTitle=driver.findElements(By.xpath("(//div[@id='jobs-list'])/div/div/div"));
        for (int i = 0; i < joblist.size(); i++) {
            if (joblist.size() > 0) {

                if( jobTitle.get(i).getText().contains("Quality Assurance")){
                    logger.info(jobTitle.get(i).getText()+"'s position contains Quality Assurance");
                   if( departmanTitle.get(i).getText().contains("Quality Assurance")){
                       logger.info(jobTitle.get(i).getText()+"'s departmant name contains Quality Assurance");
                       if( LocationTitle.get(i).getText().contains("Istanbul, Turkey")){
                           logger.info(jobTitle.get(i).getText()+"'s Location contains Istanbul, Turkey");
                       }
                       else {
                           logger.info(jobTitle.get(i).getText()+"'s Location does not contains Istanbul, Turkey");
                       }

                   }
                   else{
                       logger.info(jobTitle.get(i).getText()+"'s departmant name does not contains Quality Assurance");
                   }


                }
                else if(jobTitle.get(i).getText().contains("QA")) {

                    logger.info(jobTitle.get(i).getText()+"'s jobtitle does not contains Quality Assurance, that contains QA");
                }
                else{
                    logger.info("'s option not suitable for our expectations");

                }

            }
        }
    }
    public void ViewRole(){
        executor.executeScript("window.scrollBy(0,500);");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement RoleButton=driver.findElement(By.xpath("(//div[@class='position-list-item-wrapper bg-light'])[1]"));
        actions.moveToElement(RoleButton).perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(ViewRoleButton).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> allTabs = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(allTabs);
        driver.switchTo().window(tabs.get(1));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
