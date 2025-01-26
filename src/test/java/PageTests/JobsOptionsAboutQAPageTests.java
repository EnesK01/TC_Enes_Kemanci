package PageTests;

import PageModels.HomePage;
import PageModels.JobOptionsAboutQAPage;
import Utils.UseableMethodsForTransactions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class JobsOptionsAboutQAPageTests {
    protected WebDriver driver;
    JobOptionsAboutQAPage jobOptionsAboutQAPage;
    UseableMethodsForTransactions useableMethodsForTransactions;
    private final String baseUrl = "https://useinsider.com/careers/open-positions/?department=qualityassurance&_gl=1*1c2wnxk*_up*MQ..*_ga*MTg0ODgwNTcxOS4xNzM3ODM5ODYw*_ga_5LPMJ6EFP5*MTczNzgzOTg1OC4xLjAuMTczNzgzOTg1OC4wLjAuMA..";
    @BeforeClass
    public void SetupPage(){
        driver=new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        jobOptionsAboutQAPage=new JobOptionsAboutQAPage(driver);
        useableMethodsForTransactions=new UseableMethodsForTransactions(driver);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }
   @Test(priority = 0)
   public void ChooseLocationCheck(){
        jobOptionsAboutQAPage.ChooseLocation();
   }
  @Test(priority = 1)
  public void TitleCheck(){
        jobOptionsAboutQAPage.CheckJoblistAndPositions();
  }
    @Test(priority = 2)
    public void ApplyAndCheckApplyPage(){
        jobOptionsAboutQAPage.ViewRole();

        Assert.assertEquals(driver.getCurrentUrl(),"https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc");
    }
  @AfterClass
    public void TakeScreenShotandShutDownPage(){
        TakesScreenshot ts=(TakesScreenshot) driver;
        File screenShot=ts.getScreenshotAs(OutputType.FILE);
        String abspath= Paths.get("src\\test\\resources\\screenshots").toAbsolutePath().toString();
        String filename="İlan sayfasi sonu"+"-"+System.currentTimeMillis()+".png";
        String path=abspath+"\\"+filename;
        try {
            FileUtils.copyFile(screenShot,new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
