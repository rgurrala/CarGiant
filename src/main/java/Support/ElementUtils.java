package Support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static Support.BaseClass.driver;

public class ElementUtils {
    Properties prop;
    FileInputStream fileInputStream;
    public void clickOnDesiredNumberOfLocator(int number, By by) {
        List<WebElement> all = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        int i = 0;
        for (WebElement second : all) {
            i = i + 1;
            if (i == number) {
                second.click();
            }


        }
    }
    public String getProperty(String key) throws IOException {
        prop = new Properties();
        fileInputStream = new FileInputStream("src/test/Resources/config.properties");
        prop.load(fileInputStream);

        return prop.getProperty(key);
    }
    public WebDriver browser() throws IOException {

        String browser = getProperty("browser");

            switch (browser) {
                case "chrome":
                    ChromeOptions option = new ChromeOptions();
                    option.setExperimentalOption("w3c", false);
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(option);
                    break;
                case "headless":
                    ChromeOptions options = new ChromeOptions();
                    WebDriverManager.chromedriver().setup();
                    options.addArguments("--headless");
                    driver = new ChromeDriver(options);
                    break;

            }

            return driver;

        }
    public void sendText(By by, String text) {
       new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);

    }
    public void clickBtn(By by) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(by)).click();

    }
    public void actionsClick(By by) {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(by));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
    public void javaScriptExecutorClick(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

}
    public void assertElementLoaded(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public JSONObject getPayLoad() {
        JSONParser jsonParser = new JSONParser();
        Object object = null;
        try {
            try {

                object = jsonParser.parse(new FileReader( "src/main/java/JsonFile/cars.json"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        JSONObject json = (JSONObject) object;
        return json;
    }
    public void refreshCurrentPage(){
        driver.navigate().refresh();
    }
    public void waitForInvisibiltyOfTextAtElement(By by,String text){
        new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOfElementWithText(by, text));


    }
    public void waitForInvisibiltyOfElement(By by){
        new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOfElementLocated(by));


    }


}