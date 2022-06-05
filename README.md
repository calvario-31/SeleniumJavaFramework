# SELENIUM JAVA FRAMEWORK

To run with command line:

```sh
mvn clean test -DsuiteXmlFile=src/test/resources/suites/${suiteName} -Dbrowser=${browserName}
```

Example:

```sh
mvn clean test -DsuiteXmlFile=src/test/resources/suites/smoke.xml -Dbrowser=EDGE
```

If browser parameter is not passed it will run on CHROME

URL:

```
https://www.saucedemo.com/
```