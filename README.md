 Run tests

* mvn clean test

***
 Generate report 

* mvn allure:report

> Report will be generated tо directory: 
>> target/allure-reports/index.html

***
To run tests using Selenium Grid

java -jar selenium-server-standalone-3.9.0.jar -role hub

java -Dwebdriver.chrome.driver=C:\Users\LenaGorbach\IdeaProjects\automationpractice\src\test\resources\webdrivers\chromedriver.exe -jar selenium-server-standalone-3.9.0.jar -role node -hub http://localhost:4444/grid/register

***
>>sample log for failed test

2020-05-22 00:31:42.357 INFO [main] [utils.MyTestWatcher] [26] - ==== FAILED TEST loginRegisteredUserTest() ====
2020-05-22 00:31:42.361 INFO [main] [utils.MyTestWatcher] [27] - java.net.SocketTimeoutException: timeout
Build info: version: '3.9.0', revision: '698b3178f0', time: '2018-02-05T14:26:55.441Z'
System info: host: 'GORBACHL10', ip: '192.168.0.105', os.name: 'Windows 10', os.arch: 'amd64', os.version: '10.0', java.version: '1.8.0_181'
Driver info: driver.version: RemoteWebDriver

***