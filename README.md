                                              steps to execute the test
                                              
-install an IDE (preferable intellij, as the project has been developed on it)

-set up java and maven environment variables

-install git and set the path under intellij/file/settings/version control/git

-set up SDK under intellij/file/project structure/project settings/project

set up SDK under intellij/file/project structure/platform settings/SDKs

-install cucumber-java plug in

-check out the project from the git hub repo


                                                  project structure
                                                  
src/main/java/pages/classes- these hold methods pertaining to the relevant screens on the web site

src/main/java/support/base class- this as @Before and @After methods 

src/main/java/support/ElementUtils- have common reusable customised selenium methods

src/main/java/support/WebModel- this hold return types methods for each class, facilitates chaining of the methods

src/test/java/RunnerTest- this is cucumber runner test class. test tags are provided here.

src/test/java/StepDefinitions/Scenario_Stepdefs- hold cucumber test definitions. 

src/test/java/Resources/FeatureFile/Scenario.feature- holds cucumber test scenario. 

src/test/java/Resources/config/properties- holds properties for browser and URL

output- folder generates a report.html of the result. files refreshes for each test execution.  

screenshots-hold .png files of the screen shot upon scenario failure
