package PageTests;

import PageModels.CareerPage;
import Utils.UseableMethodsForTransactions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class CareerPageTests{
    protected WebDriver driver;
    CareerPage careerPage;
    UseableMethodsForTransactions useableMethodsForTransactions;
    private final String baseUrl = "https://useinsider.com/careers/";

    @BeforeClass
    public void SetupPage() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        careerPage = new CareerPage(driver);
        useableMethodsForTransactions = new UseableMethodsForTransactions(driver);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void CareerPageIsLoaded() {
        useableMethodsForTransactions.IsPageLoadedSuccessFully();
    }

    @Test(priority = 1)
    public void CareerPageElementsOnthePage() {
        careerPage.CareerPageIsCheckingByElementsExisting();
    }

    @AfterClass
    public void TakeScreenShotandShutDownPage() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenShot = ts.getScreenshotAs(OutputType.FILE);
        String abspath = Paths.get("src\\test\\resources\\screenshots").toAbsolutePath().toString();
        String filename = "Kariyer sayfasi sonu islemleri" + System.currentTimeMillis() + ".png";
        String path = abspath + "\\" + filename;

        try {
            FileUtils.copyFile(screenShot, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();
    }

}
