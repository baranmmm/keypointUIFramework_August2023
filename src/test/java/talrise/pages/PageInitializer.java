package talrise.pages;

import talrise.utilities.Driver;

public class PageInitializer extends Driver {

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static ProfilePage profilePage;



    public static void initialize(){
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        profilePage = new ProfilePage();

    }
}
