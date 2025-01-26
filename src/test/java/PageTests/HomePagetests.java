package PageTests;

import PageModels.HomePage;
import Utils.UseableMethodsForTransactions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class HomePagetests {
    protected WebDriver driver;
    HomePage homePage;
    UseableMethodsForTransactions useableMethodsForTransactions;
    private final String baseUrl = "https://useinsider.com/";
    @BeforeClass
    public void SetupPage(){
        driver=new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        homePage=new HomePage(driver);
        useableMethodsForTransactions=new UseableMethodsForTransactions(driver);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }
    @Test(priority = 0)
    public void MainPageLoaded(){
        useableMethodsForTransactions.IsPageLoadedSuccessFully();
    }
    @Test(priority = 1)
    public void GoesToCareerPageFromHomePage(){
        homePage.ChooseOptionsForCareerPage();
    }

    @AfterClass
    public void TakeScreenShotandShutDownPage(){
        TakesScreenshot ts=(TakesScreenshot) driver;
        File screenShot=ts.getScreenshotAs(OutputType.FILE);
        String abspath= Paths.get("src\\test\\resources\\screenshots").toAbsolutePath().toString();
        String filename="Ana Sayfa sonu islemleri"+"-"+System.currentTimeMillis()+".png";
        String path=abspath+"\\"+filename;
        try {
            FileUtils.copyFile(screenShot,new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
