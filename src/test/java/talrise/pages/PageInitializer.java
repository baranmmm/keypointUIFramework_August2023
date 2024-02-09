package talrise.pages;

import talrise.pages.candidate.firstLoginProfile.*;
import talrise.pages.candidate.normalProfile.*;
import talrise.pages.superadmin.JobListPage;
import talrise.pages.superadmin.SuperadminDashboardPage;
import talrise.utilities.Driver;

public class PageInitializer extends Driver {

    public static LoginPage loginPage;
    public static CandidateDashboardPage candidateDashboardPage;
    public static ProfilePage profilePage;
    public static RegisterPage registerPage;
    public static PersonalInfoPage personalInfoPage;
    public static SuperadminDashboardPage superadminDashboardPage;
    public static PreferencesPage preferencesPage;
    public static OverviewPage overviewPage;
    public static ExperiencePage experiencePage;
    public static EducationPage educationPage;
    public static LanguagePage languagePage;
    public static ProfileSectionPage profileSectionPage;
    public static JobListPage jobListPage;
    public static FirstLoginPersonalInfoPage firstLoginPersonalInfoPage;
    public static PositionPage positionPage;
    public static FirstLoginLanguagePage firstLoginLanguagePage;
    public static FirstLoginExperiencePage firstLoginExperiencePage;


    public static void initialize(){
        loginPage = new LoginPage();
        candidateDashboardPage = new CandidateDashboardPage();
        profilePage = new ProfilePage();
        registerPage=new RegisterPage();
        personalInfoPage=new PersonalInfoPage();
        superadminDashboardPage = new SuperadminDashboardPage();
        preferencesPage = new PreferencesPage();
        overviewPage = new OverviewPage();
        experiencePage = new ExperiencePage();
        educationPage = new EducationPage();
        languagePage = new LanguagePage();
        profileSectionPage =new ProfileSectionPage();
        jobListPage = new JobListPage();
        firstLoginPersonalInfoPage = new FirstLoginPersonalInfoPage();
        positionPage = new PositionPage();
        firstLoginLanguagePage = new FirstLoginLanguagePage();
        firstLoginExperiencePage = new FirstLoginExperiencePage();
    }
}
