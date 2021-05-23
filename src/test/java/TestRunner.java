import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\TestingBikeAPI\\src\\test\\resources\\features\\APITesting.feature"}
        ,plugin ={
        "pretty",
        "html:results/html/cucumber.html"
},
        monochrome = true
)

public class TestRunner {
}
