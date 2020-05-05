
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter:output/report.html"}

        ,tags={"@one"})
public class RunnerTest {

}
