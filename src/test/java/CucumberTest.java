import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import Conditions.AllureReporter;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Scenarios"},
        glue = {"Glue/"},
        plugin = {"Conditions.AllureReporter"}
)

public class CucumberTest {

}
