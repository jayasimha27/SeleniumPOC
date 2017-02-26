@echo off
start java -jar "%GRID_HOME%\selenium-server-standalone-2.53.1.jar" -role hub
start java -jar "%GRID_HOME%\selenium-server-standalone-2.53.1.jar" -role webdriver -nodeConfig "%GRID_HOME%\selenium-node-win-firefox45.cfg.json"
start java -jar "%GRID_HOME%\selenium-server-standalone-2.53.1.jar" -role webdriver -Dwebdriver.ie.driver="%GRID_HOME%\IEDriverServer.exe" -nodeConfig "%GRID_HOME%\selenium-node-win-ie7.cfg.json"
start java -jar "%GRID_HOME%\selenium-server-standalone-2.53.1.jar" -role webdriver -Dwebdriver.chrome.driver="%GRID_HOME%\chromedriver.exe" -nodeConfig "%GRID_HOME%\selenium-node-win-chrome51.cfg.json"
exit /B