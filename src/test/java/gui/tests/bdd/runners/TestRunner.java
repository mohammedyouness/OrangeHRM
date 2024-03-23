package gui.tests.bdd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/java/gui/tests/bdd/features/Admin.feature"
        ,glue = "gui/tests/bdd/steps",tags = "@e2eTest", plugin = {"pretty" , "html:target/report.html"})
public class TestRunner {
}