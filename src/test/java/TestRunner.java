import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        //This is the path to your all cucumber feature files
        features = "classpath:features",
        //This is the path to your all step definition classes
        glue = "stepdefinitions",
        //You can use tags to choose what test you want to run. Also make sure you have
        //tagged the test cases in your feature file
        tags = "@Regression"
)

public class TestRunner {

}