package talrise.pages;

import talrise.utilities.Driver;

public class PageInitializer extends Driver {

    public static LoginPage loginPage;



    public static void initialize(){
        loginPage = new LoginPage();

    }
}
