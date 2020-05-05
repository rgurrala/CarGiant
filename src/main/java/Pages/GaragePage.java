package Pages;

import Support.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static Support.BaseClass.driver;

public class GaragePage {
    ElementUtils utils=new ElementUtils();
public List<WebElement>listOfallShortListedCars;
public List<String> extractAllShortListedCarNames;
    public String deletedCar;
    private String clickNext="//span[@class='watch-next slick-arrow']";
    private String onScreenCarName="//div[@role='tabpanel']/div[2]/h3";


    public void verifyCarsInTheWishList() throws InterruptedException {
       utils.assertElementLoaded(By.xpath(onScreenCarName));
        listOfallShortListedCars=driver.findElements(By.xpath(onScreenCarName));
       extractAllShortListedCarNames=new ArrayList<>();
        for (WebElement element:listOfallShortListedCars){
            Thread.sleep(1000);
            String carOnScreen=element.getText();
            extractAllShortListedCarNames.add(carOnScreen);
            Assert.assertTrue(utils.getPayLoad().toString().contains(carOnScreen));
            utils.javaScriptExecutorClick(By.xpath(clickNext));
        }
    }
    public void editWishList() {
        new WebDriverWait(driver,10).until(ExpectedConditions.textToBe(By.xpath(onScreenCarName),extractAllShortListedCarNames.get(0)));
        deletedCar=driver.findElement(By.xpath(onScreenCarName)).getText();
        utils.clickOnDesiredNumberOfLocator(2,By.xpath("//span[text()='Remove from watchlist']"));
        //i had to introduce a page refresh here due to glitches in html dome refresh after the click action
        utils.refreshCurrentPage();
    }

    public void assertChangesInTheUpdatedWishList() throws InterruptedException {
        List<WebElement>updatedCarList=driver.findElements(By.xpath(onScreenCarName));
        for(WebElement element:updatedCarList){
            Assert.assertNotSame(element.getText(), deletedCar);
            utils.javaScriptExecutorClick(By.xpath(clickNext));
        }
    }
}
