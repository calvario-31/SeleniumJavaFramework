# SELENIUM JAVA FRAMEWORK

To run with command line:

```sh
mvn clean test -DsuiteName=${suiteName} -Dbrowser=${browserName}
```

Example:

```sh
mvn clean test -DsuiteName=regression -Dbrowser=EDGE
```

If browser parameter is not passed it will run on CHROME

To do a static analysis and show the report:

```sh
mvn clean checkstyle:checkstyle site
```

URL:

```
https://www.saucedemo.com/
```