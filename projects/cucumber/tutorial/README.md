# AI-poc

Cucumber demo
---------

REFs:
https://cucumber.io/docs/guides/10-minute-tutorial/

# Create an empty Cucumber project
We'll start by creating a new project directory with the cucumber-archetype Maven plugin. Open a terminal, go to the directory where you want to create your project, and run the following command:

```mvn
mvn archetype:generate                     \
"-DarchetypeGroupId=io.cucumber"           \
"-DarchetypeArtifactId=cucumber-archetype" \
"-DarchetypeVersion=7.29.0"                \
"-DgroupId=hellocucumber"                  \
"-DartifactId=hellocucumber"               \
"-Dpackage=hellocucumber"                  \
"-Dversion=1.0.0-SNAPSHOT"                 \
"-DinteractiveMode=false"
```


mvn archetype:generate "-DarchetypeGroupId=io.cucumber" "-DarchetypeArtifactId=cucumber-archetype" "-DarchetypeVersion=7.29.0" "-DgroupId=hellocucumber" "-DartifactId=hellocucumber" "-Dpackage=hellocucumber" "-Dversion=1.0.0-SNAPSHOT" "-DinteractiveMode=false"


cd hellocucumber

mvn test