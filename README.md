# SELENIUM JAVA FRAMEWORK

To run with command line:
```sh
mvn clean test -DsuiteName=${suiteName} -Dbrowser=${browserName}
```

Example:
```sh
mvn clean test -DsuiteName=smoke -Dbrowser=EDGE
```

If browser parameter is not passed it will run on CHROME

URL:
```
https://www.saucedemo.com/
```