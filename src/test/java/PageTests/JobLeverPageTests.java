package PageTests;

import PageModels.HomePage;
import PageModels.JobLeverPage;
import Utils.UseableMethodsForTransactions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class JobLeverPageTests {
    protected WebDriver driver;
    JobLeverPage jobLeverPage;
    UseableMethodsForTransactions useableMethodsForTransactions;
    private final String baseUrl="https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc";
    @BeforeClass
    public void SetupPage(){
        driver=new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        jobLeverPage=new JobLeverPage(driver);
        useableMethodsForTransactions=new UseableMethodsForTransactions(driver);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }
    @Test(priority = 0)
    public void MainPageLoaded(){
        useableMethodsForTransactions.IsPageLoadedSuccessFully();
    }
    @AfterClass
    public void TakeScreenShotandShutDownPage() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenShot = ts.getScreenshotAs(OutputType.FILE);
        String abspath = Paths.get("src\\test\\resources\\screenshots").toAbsolutePath().toString();
        String filename = "Jobs lever sayfa sonu" + System.currentTimeMillis() + ".png";
        String path = abspath + "\\" + filename;

        try {
            FileUtils.copyFile(screenShot, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
