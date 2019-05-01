import java.util.List;
import java.util.Map;

import org.testng.*;
import org.testng.xml.XmlSuite;

public class CustomReporter implements IReporter{
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                               String outputDirectory) {

        //Iterating over each suite included in the test
        for (ISuite suite : suites) {

            //Following code gets the suite name
            String suiteName = suite.getName();

            //Getting the results for the said suite
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult sr : suiteResults.values()) {
                ITestContext tc = sr.getTestContext();
                System.out.println("Passed tests for suite '" + suiteName +
                        "' is:" + tc.getPassedTests().getAllResults().size());
                System.out.println("Failed tests for suite '" + suiteName +
                        "' is:" + tc.getFailedTests().getAllResults().size());
                System.out.println("Skipped tests for suite '" + suiteName +
                        "' is:" + tc.getSkippedTests().getAllResults().size());

                System.out.println("The passed tests are:");
                for ( ITestResult testResult : tc.getPassedTests().getAllResults() )
                {
                    System.out.println(testResult.getName().toString());
                }
            }
        }
    }
}