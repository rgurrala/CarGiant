package StepDefinitions;

import Support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

public class Scenario_Stepdefs {

    WebModel webModel = new WebModel();

    @Given("^the user has logged in to the carGiant portal$")
    public void theUserHasLoggedInToTheCarGiantPortal() throws IOException {
        //plase provide a valid username and password
        webModel.getLoginPage().login(webModel.getUtils().getProperty("userName"), webModel.getUtils().getProperty("password"));
        webModel.getLoginPage().assertMyGarage();
        //this method clears previous wish list if any
        webModel.getLoginPage().clearWishList();

    }

    @When("^he searches for \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" car manufacturers and shortlist the desired models$")
    public void heSearchesForAndCarManufacturersAndShortlistTheDesiredModels(String audi, String bmw, String mercedes) throws InterruptedException {
        webModel.getSearchAndReservePage().navigateToSearchAndReserve();
        // the brand name is derived from feature file
        webModel.getSearchAndReservePage().searchByMake(audi, "Audi");
        //the model name is derived from json file
        webModel.getSearchAndReservePage().shortListCars("Audi");
        // this method switches the current searched option. in total 3 brands are searched and 3 models short listed
        webModel.getSearchAndReservePage().switchSelectionAndSearch(bmw, "audi", "BMW");
        webModel.getSearchAndReservePage().shortListCars("Bmw");
        webModel.getSearchAndReservePage().switchSelectionAndSearch(mercedes, "bmw", "Mercedes");
        webModel.getSearchAndReservePage().shortListCars("Mercedes");

    }

    @When("^navigates to the wishlist$")
    public void NavigatesToTheWishlist() {
        webModel.getSearchAndReservePage().navigateToGarage();
    }

    @Then("^he should be able to find all the short listed cars$")
    public void heShouldBeAbleToFindAllTheShortListedCars() throws InterruptedException {
        //this method verifies that only the shortlisted models end up in the wish list. car models are verified against the json file
        webModel.getGaragePage().verifyCarsInTheWishList();
    }

    @And("^he should be able to edit the list and assert the changes$")
    public void heShouldBeAbleToEditTheListAndAssertTheChanges() throws InterruptedException {
        //here the first model in the list is deleted
        webModel.getGaragePage().editWishList();
        //this method will check and assert that the car model is indeed deleted from the list
        webModel.getGaragePage().assertChangesInTheUpdatedWishList();
    }



}
