package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"json:target/cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports/Cucumber.html",
                "pretty", "summary", "html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        publish = true,
        features = "src/test/resources/Features",
        glue = "Step_Definitions",
        dryRun = false,
        tags = "@mobileTest"


//mvn clean verify "-DargLine=-Denvironment=web -Dcucumber.filter.tags='@webTest'"
//mvn clean verify "-DargLine=-Denvironment=mobile -Dcucumber.filter.tags='@mobileTest'"





)


public class CukesRunner {


}