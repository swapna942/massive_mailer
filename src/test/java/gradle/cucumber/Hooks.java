package gradle.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import gradle.cucumber.driver.SingleDrive;
import gradle.cucumber.driver.WebDriverWrapper;
import org.flywaydb.core.Flyway;

public class Hooks {

    @Before
    public void beforeScenario() {
        SingleDrive.getDriver().visit("http://localhost:8080/massive_mailer/reset.jsp");
    }

    @After
    public void afterScenario() {
        SingleDrive.reset();
    }
}
