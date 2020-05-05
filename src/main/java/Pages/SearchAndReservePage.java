package Pages;

import Support.ElementUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
public class SearchAndReservePage {
    ElementUtils utils=new ElementUtils();

    public void navigateToSearchAndReserve(){
        utils.clickBtn(By.xpath("//span[text()[contains(.,' Find a car')]]"));
        utils.assertElementLoaded(By.xpath("//h3[text()[contains(.,'Search & Reserve Cars')]]"));
    }

    public void searchByMake(String make, String brandName){
        utils.clickBtn(By.xpath("//a[text()='Make']"));
        utils.clickBtn(By.xpath("//a[@data-value='"+make+"']"));
        utils.clickBtn(By.xpath("//button[@type='submit']"));
        utils.assertElementLoaded(By.xpath("//h1[text()='Used "+brandName+" for Sale in London']"));
    }
    public void shortListCars(String make){
        JSONObject jsonObject=utils.getPayLoad();
        utils.actionsClick(By.xpath("//a[text()='"+jsonObject.get(make)+"']"));
       utils.clickBtn(By.xpath("//a[@data-action='Add to Watchlist_Car Details']"));
        utils.clickBtn(By.xpath("//a[@title='Back To Results']"));
    }
    public void switchSelectionAndSearch(String newSelection,String oldSelection,String brandName) throws InterruptedException {
       utils.clickBtn(By.xpath("//label[text()='Make']"));
        utils.actionsClick(By.xpath("//a[@data-value='"+newSelection+"']"));
        //i had to introduce sleep here due to the glitches in the screen update
        Thread.sleep(2000);
        utils.actionsClick(By.xpath("//a[@data-value='"+oldSelection+"']"));
       utils.assertElementLoaded(By.xpath("//h1[text()='Used "+brandName+" for Sale in London']"));
    }
    public void navigateToGarage(){
        utils.clickBtn(By.xpath("//a[text()='My Garage']"));
    }
}
