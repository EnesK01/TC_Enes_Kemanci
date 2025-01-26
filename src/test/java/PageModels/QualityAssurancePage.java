package PageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QualityAssurancePage {
    protected WebDriver driver;
    By SeeAllQAjobs=By.xpath("//a[@class='btn btn-outline-secondary rounded text-medium mt-2 py-3 px-lg-5 w-100 w-md-50']");

    public QualityAssurancePage(WebDriver driver) {
        this.driver = driver;
    }
    public void SeeAllJobsAboutQA(){
        driver.findElement(SeeAllQAjobs).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
