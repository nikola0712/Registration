# Registration

This is project which is running automated tests on JAVA, Selenium and Cucumber with gherkin feature file.

Tests will run against registration form on provided url in project.

Download this repo, and from feature file Registration.feature and click on Run button from your IDE.

Suggested IDE: IntelliJ (community will do), Eclipse, VS Code

Upon opening project in IDE, few things are needed for project:
-JDK
-Gherkin
-Cucumber

If no JDK is configured, IDE will offer to set it up so java project can be ran.

As for Cucumber and Gherkin just go to Plugins (for IntelliJ it's under File > Settings > Plugins 

and from marketplace download Cucumber for Java and Gherkin.

Then open Registration.feature file from src/test/features/Registration.feature and right click on file and press run scenario
or press run button on left side of feature file.

Tests will start with opening chrome driver which is already included in project and setup as well as selenium jars.


