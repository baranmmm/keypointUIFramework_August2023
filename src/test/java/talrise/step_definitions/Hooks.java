package talrise.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import talrise.utilities.CommonSteps;
import talrise.utilities.ConfigurationReader;
import talrise.utilities.Driver;

public class Hooks {

    @Before
    public void setUp() {
        Driver.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        byte[] picture;
        if (scenario.isFailed()) {
            // take screenshot and save it in /failed
            picture = CommonSteps.takeScreenshot("failed/" + scenario.getName()); // notes
            scenario.attach(picture, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }






}

