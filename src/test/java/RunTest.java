import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources",//path to the features
        format = {"pretty", "json:target/cucumber.json"},//what formatters to use
        tags = {"@run"})//what tags to incluse(@)/exclude(@~)

public class RunTest {
}
