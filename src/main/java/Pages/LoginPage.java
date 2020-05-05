package Pages;

import Support.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

import static Support.BaseClass.driver;

public class LoginPage {
    ElementUtils utils=new ElementUtils();
    private String onScreenCarName="//div[@class='row whatchlist-item slick-slide slick-current slick-active']/div[2]/h3";

public void login(String userName,String password){
    utils.sendText(By.id("PartialLogin_Username"),userName);
    utils.sendText(By.id("PartialLogin_Password"),password);
    welcomePopupWhileLogin();
    utils.clickBtn(By.xpath("//input[@value='Sign in']"));

}
public void welcomePopupWhileLogin(){
   try {
       utils.assertElementLoaded(By.xpath("//span[text()[contains(.,'Buy Your New Car Online')]]"));
       utils.clickBtn(By.xpath("//span[text()[contains(.,'CLOSE')]]"));
   }catch (Exception e){
       System.out.println("missing welcome pop up during login");
   }
}

public void assertMyGarage(){
    utils.assertElementLoaded(By.xpath("//h2[text()=' My watchlist']"));
}
public void clearWishList(){
    try {
        List<WebElement> removeButtons = driver.findElements(By.xpath("//span[text()='Remove from watchlist']"));
        for (WebElement removeButton : removeButtons) {
            if (removeButton.isDisplayed()) {
                String nameOFTheCar = driver.findElement(By.xpath(onScreenCarName)).getText();
                removeButton.click();
                utils.waitForInvisibiltyOfTextAtElement(By.xpath(onScreenCarName),nameOFTheCar);
            }

        }
    } catch (Exception e) {

    }
}

}
