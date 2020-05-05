package Support;

import Pages.GaragePage;
import Pages.LoginPage;
import Pages.SearchAndReservePage;

public class WebModel {
    private  ElementUtils utils = new ElementUtils();
    private LoginPage loginPage=new LoginPage();
    private GaragePage garagePage=new GaragePage();
    private SearchAndReservePage searchAndReservePage=new SearchAndReservePage();


    public ElementUtils getUtils() {
        return utils;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public GaragePage getGaragePage() {
        return garagePage;
    }

    public SearchAndReservePage getSearchAndReservePage() {
        return searchAndReservePage;
    }
}
