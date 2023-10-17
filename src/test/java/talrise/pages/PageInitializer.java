package talrise.pages;

import talrise.utilities.Driver;

public class PageInitializer extends Driver {

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static ProfilePage profilePage;
    public static RegisterPage registerPage;
    public static PersonalInfoPage personalInfoPage;
    public static OverviewPage overviewPage;
    public static PreferencesPage preferencesPage;
    public static LanguagePage languagePage;
    public static ExperiencePage experiencePage;


    public static void initialize(){
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        profilePage = new ProfilePage();
        registerPage=new RegisterPage();
        personalInfoPage=new PersonalInfoPage();
        preferencesPage=new PreferencesPage();
        overviewPage = new OverviewPage();
        experiencePage=new ExperiencePage();
        languagePage=new LanguagePage();

    }
}
