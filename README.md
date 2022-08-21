### Features Supported by Framework


<li>Use of DataTable and Doc String
<li>Use of Tag, Hooks and Scenario Outline.
<li>Logging on both console and file level.
<li>Extent reporting(In case of failure base 64 image Screenshot gets attached in report).

### How to use this framework?<br>

<li>Download the project and unzip it then import it in IDE.
<li>Directly run testng xml file.
<li>To run from maven, go to project path and run 'mvn clean test'(testng.xml is set bydefault in surefire plugin currently<br>
and if want to run any  other testng file then set it in surefire plugin then run 'mvn clean test').
<li>After execution, generated logs would be in console and file(/logs/current/timestamp), while report would be generated inside test-results/current-test-results/timestamp.
<li>Extent Report would automatically open inside browser after execution.
<li>To run only failed scenario after execution, Please run failedScenario-testng.xml file



