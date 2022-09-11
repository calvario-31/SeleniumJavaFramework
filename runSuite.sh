./mvnw clean test -DsuiteName=smoke -DheadlessMode=true allure:serve \
1> src/test/resources/logs/mavenOutput.log \
2> src/test/resources/logs/stdErrorMavenOutput.log