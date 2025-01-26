package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UseableMethodsForTransactions {
    protected WebDriver driver;
    private static final Logger logger= LoggerFactory.getLogger(UseableMethodsForTransactions.class);
    public UseableMethodsForTransactions(WebDriver driver){
        this.driver=driver;
    }

    public void IsPageLoadedSuccessFully() {
        JavascriptExecutor executor=(JavascriptExecutor) driver;
        while(!executor.executeScript("return document.readyState").equals("complete")){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
               logger.info("Sayfa yükleniyor : "+e+" \n");
            }
        }
    logger.info("Sayfa basarili sekilde yuklendi");

    }
}
