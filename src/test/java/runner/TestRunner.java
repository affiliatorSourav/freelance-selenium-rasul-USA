package runner;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        //This is the path to your all cucumber feature files
        features = "src/test/resources/features",
        //This is the path to your all step definition classes
        glue = "stepdefinitions",
        monochrome=true,
        dryRun=false,
        //You can use tags to choose what test you want to run. Also make sure you have
        //tagged the test cases in your feature file
        tags = "@Login"
)

public class TestRunner {

}