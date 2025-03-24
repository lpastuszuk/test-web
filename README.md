# test-web
Basic WEB test framework

Prerequisites:
---------------
* Java 21 (e.g. [jdk-21.0.6+7 AdoptOpenJDK](https://adoptopenjdk.net/))
* [Chrome 134.0.6998.165 with Chromedriver 134.0.6998.165](https://googlechromelabs.github.io/chrome-for-testing/) or [Firefox 136.0.2](https://www.mozilla.org/en-US/firefox/all/) with [Geckodriver 0.36.0](https://github.com/mozilla/geckodriver/releases)

Instructions:
---------------
* Driver executables should be placed in path specified in `src/test/resources/selenide.properties` (default is `drivers` folder)
* Browser can be configured in `src/test/resources/selenide.properties` (default is `chrome`)
* `./mvnw clean test` - run tests
* Test results are stored in `target/test-report` folder in .html format
* `./mvnw allure:serve` - optionally serve Allure report
* Logs are output to console with INFO level, can be configured in `src/test/resources/log4j2.xml`