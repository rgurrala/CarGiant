package Support;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.OutputType.BYTES;


public class BaseClass {
    public static WebDriver driver;
    WebModel webModel = new WebModel();

    @Before()
    public void startUp() throws IOException {
        driver = webModel.getUtils().browser();
        driver.get(webModel.getUtils().getProperty("URL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }


    @After
    public void tearDown(Scenario scenario) throws IOException {


        if (scenario.isFailed()) {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File location = camera.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(location, new File("./screenShots/" + scenario.getName() + ".png"));
            byte[] screenShot = camera.getScreenshotAs(BYTES);
            scenario.embed(screenShot, "image/png");
            System.out.println("scenario failed");
        }
driver.quit();
    }}
