package StepDefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = "src/test/resources/features",

        glue = {"StepDefination", "Hooks"},

        plugin = {

               
                "pretty",

                
                "html:target/htmlreports/report.html",

               
                "json:target/jsonreports/report.json",

               
                "junit:target/xmlreports/report.xml",

              
                "testng:target/testngreports/report.xml",

                
                "rerun:target/failed_scenarios.txt"

        },

        monochrome = true,

        dryRun = false,

        publish = true

)

public class TestRunner {

}